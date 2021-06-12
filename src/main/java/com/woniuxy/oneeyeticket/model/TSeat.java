package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 座位信息
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TSeat implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "seat_id", type = IdType.AUTO)
    private Integer seatId;

    /**
     * 关联的影厅
     */
    private Integer hallId;

    /**
     * 0不可选,1可选,2已选
     */
    private String status;

    /**
     * 横坐标
     */
    private Integer seatX;

    /**
     * 纵坐标
     */
    private Integer seatY;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}
