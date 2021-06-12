package com.woniuxy.oneeyeticket.service.impl;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.oneeyeticket.config.Alipay;
import com.woniuxy.oneeyeticket.controller.from.OrderFrom;
import com.woniuxy.oneeyeticket.model.TOrder;
import com.woniuxy.oneeyeticket.dao.TOrderMapper;
import com.woniuxy.oneeyeticket.pojo.AlipayPojo;
import com.woniuxy.oneeyeticket.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Service
@Slf4j
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {
    //创建订单
    @Resource
    private TOrderMapper tOrderMapper;
    @Autowired
    private Alipay alipay;
    @Override
    public Integer create(OrderFrom orderFrom) {
        TOrder order = new TOrder();
        log.info("{}",orderFrom);
        BeanUtils.copyProperties(orderFrom,order);
        //生成订单号
        order.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        //支付渠道
        order.setPaymentChannel("ZFB");
        //修改支付状态(订单创建为未支付)
        order.setStatus("INIT");
        //记录创建时间
        order.setCreateTime(new Date());
        tOrderMapper.insert(order);
        return order.getOrderId();
    }
    //支付宝

    //根据用户id查询用户订单
    @Override
    public TOrder selectTorderByUserId(int orderId) {
        QueryWrapper<TOrder> Wrapper = new QueryWrapper<>();
        Wrapper.eq("order_id",orderId);
        TOrder order = tOrderMapper.selectOne(Wrapper);
        return order;
    }
    //根据用户id修改订单的状态
    @Override
    public Integer updateOrderStatus(int userId,Integer orderId) {
        QueryWrapper<TOrder> Wrapper = new QueryWrapper<>();
        Wrapper.eq("user_id",userId);
        Wrapper.eq("order_id",orderId);
        TOrder order = new TOrder();
        order.setStatus("CANCEL");
        tOrderMapper.update(order,Wrapper);
        return userId;
    }

    @Override
    public List<TOrder> selectOrderByStatus(Integer userId) {
        List<TOrder> tOrders = tOrderMapper.selectOrderByStatus(userId);
        return tOrders;
    }
    //订单删除

}
