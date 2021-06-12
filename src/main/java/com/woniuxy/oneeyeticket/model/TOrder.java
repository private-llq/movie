package com.woniuxy.oneeyeticket.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 电影放映表id
     */
    private Integer showmovieId;

    /**
     * 状态：INIT未支付 | PAID 已支付 | CANCEL 已取消
     */
    private String status;

    /**
     * 支付渠道：ZFB 支付宝 | WECHAT 微信
     */
    private String paymentChannel;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 支付订单号，支付渠道的单号
     */
    private String paymentNo;

    /**
     * 创建时间
     */
    //后端返回前端时间格式的处理
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date payTime;

    /**
     * 支付回调时间
     */
    private Date callbackTime;

    private String seat;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}
