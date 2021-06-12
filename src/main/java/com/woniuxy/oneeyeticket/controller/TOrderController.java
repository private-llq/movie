package com.woniuxy.oneeyeticket.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.woniuxy.oneeyeticket.commom.Result;
import com.woniuxy.oneeyeticket.config.AliPayConfig;
import com.woniuxy.oneeyeticket.config.Alipay;
import com.woniuxy.oneeyeticket.controller.from.OrderFrom;
import com.woniuxy.oneeyeticket.dao.TOrderMapper;
import com.woniuxy.oneeyeticket.model.TOrder;
import com.woniuxy.oneeyeticket.pojo.AlipayPojo;
import com.woniuxy.oneeyeticket.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@RestController
@CrossOrigin
public class TOrderController {
    @Autowired
    private Alipay alipay;
    @Resource
    private ITOrderService itOrderService;
    @Resource
    private AliPayConfig aliPayConfig;
    @Resource
    private TOrderMapper tOrderMapper;
    //新增订单
    @PostMapping("/addorder")
    public Result addOrder(@RequestBody OrderFrom orderFrom){
        System.out.println(orderFrom);
        Integer integer = itOrderService.create(orderFrom);
        System.out.println(integer);
        return Result.success(integer);
    }
    //跳转支付宝页面
    //String order_no:订单号
    // String subject商品描述，这里用id代替
    // String totalAmoun:订单金额
    @PostMapping("/alipay")
    public String alipay (String outTradeNo, String subject,String totalAmount, String description) throws AlipayApiException {
        //获取订单id，支付宝接口调用必备
        AlipayPojo alipayPojo = new AlipayPojo();
        alipayPojo.setOut_trade_no(outTradeNo);
        alipayPojo.setSubject(subject);
        alipayPojo.setTotal_amount(totalAmount);
        alipayPojo.setDescription(description);
        System.out.println(alipayPojo);
        return alipay.pay(alipayPojo);
    }
    //查询该订单详情
    @GetMapping("/selectOrder")
    public Result selectOrder(Integer orderId){
        TOrder order = itOrderService.selectTorderByUserId(orderId);
        return Result.success(order);
    }
    //根据用户id取消支付
        @GetMapping("/updateOrder")
        public Result updateOrderStatus(Integer userId,Integer orderId){
            Integer integer = itOrderService.updateOrderStatus(userId,orderId);
            System.out.println(integer);
        return Result.success(integer);
    }
    //根据支付状态查询订单
    @GetMapping("/selectStatus")
    public Result selectStatus(Integer userId){
        List<TOrder> tOrders = itOrderService.selectOrderByStatus(userId);
        return Result.success(tOrders);
    }
    //支付宝异步回调
    @PostMapping("/returnAlipay")
    @ResponseBody
    public String notifyCallback(HttpServletRequest request) throws Exception {
        System.out.println("进入异步");
        String success = "success";
        String failure = "failure";
        // 获取支付宝异步回调信息, 将其转为 Map<String, String>
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }

        // 新版 SDK 不用移除 sign_type
        // params.remove("sign_type");

        // 验签
        boolean signVerified = AlipaySignature.rsaCheckV1(params,aliPayConfig.getPublicKey(),
                aliPayConfig.getCharset(), aliPayConfig.getSignType());;

        if(signVerified){ // 验签通过
            //获取订单号
            String out_trade_no = requestParams.get("out_trade_no")[0];
            //获取支付宝流水号
            String trade_no = requestParams.get("trade_no")[0];
            QueryWrapper<TOrder> warpper = new QueryWrapper<>();
            warpper.eq("order_no",out_trade_no);
            //查询
            TOrder order = tOrderMapper.selectOne(warpper);
            //修改支付状态
            order.setStatus("PAID");
            //添加支付完成时间
            order.setPayTime(new Date());
            //添加支付回调事件
            order.setCallbackTime(new Date());
            //添加订单完成事件
            order.setFinishTime(new Date());
            //这里没有做支付宝返回参数接收，所以支付吧订单号给个假的随机值
            order.setPaymentNo(trade_no);
            tOrderMapper.updateById(order);
            return success;
        }else{ // 验签失败
            return failure;
        }
    }
}

