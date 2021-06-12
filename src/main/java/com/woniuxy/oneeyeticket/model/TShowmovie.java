package com.woniuxy.oneeyeticket.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 电影放映表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TShowmovie implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "showmovie_id", type = IdType.AUTO)
    private Integer showmovieId;

    /**
     * 电影的id
     */
    private Integer movieId;

    /**
     * 影厅的id
     */
    private Integer hallId;

    /**
     * 上映的时间
     */
    private Date showTime;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}
