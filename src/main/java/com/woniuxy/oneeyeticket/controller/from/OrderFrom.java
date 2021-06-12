package com.woniuxy.oneeyeticket.controller.from;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderFrom {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 电影放映表id
     */
    private Integer showmovieId;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    /**
     * 座位
     */
    private String seat;
}
