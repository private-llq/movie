package com.woniuxy.oneeyeticket.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 电影信息
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TMovie implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId(value = "movie_id", type = IdType.AUTO)
    private Integer movieId;

    /**
     * 年份
     */
    @TableField("YEAR")
    private String year;

    /**
     * 电影名
     */
    private String title;

    /**
     * 宣传图片
     */
    private String poster;

    /**
     * 剧情介绍
     */
    private String summary;
    /**
     * 状态
     */
    private String status;

    /**
     * 语言
     */
    private String languages;

    /**
     * 时长
     */
    private Integer duration;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}
