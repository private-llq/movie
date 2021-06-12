package com.woniuxy.oneeyeticket.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 购票流程所有信息
 * </p>
 *
 * @author Merlin
 * @since 2021-04-15
 */
@Data
public class TshowFrom implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * 院线表ID
     */
    private Integer cinemaId;

    /**
     * 院线名字
     */
    private String cinemaName;

    /**
     * 院线位置
     */
    private String cinemaPosition;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     *影厅名字
     */
    private String hallName;

    /**
     * 上映时间
     */
    private Date showTime;

    /**
     * 价格
     */
    private double price;

    /**
     *电影Id
     */
    private Integer movieId;

    /**
     * 电影名称
     */
    private String title;

    /**
     * 地区Id
     */
    private Integer areaId;

    /**
     * 观影厅id
     */
    private Integer hallId;



}
