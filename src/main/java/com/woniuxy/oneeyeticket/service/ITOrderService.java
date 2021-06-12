package com.woniuxy.oneeyeticket.service;

import com.alipay.api.AlipayApiException;
import com.woniuxy.oneeyeticket.controller.from.OrderFrom;
import com.woniuxy.oneeyeticket.model.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.oneeyeticket.pojo.AlipayPojo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface ITOrderService extends IService<TOrder> {
    //订单创建
    Integer create(OrderFrom orderFrom);
    //订单查询
    TOrder selectTorderByUserId(int orderId);
    //根据用户id，和订单id修改订单状态
    Integer updateOrderStatus(int userId,Integer orderId);
    //根据用户id查询已支付订单和未支付订单
    List<TOrder> selectOrderByStatus(Integer userId);
}
