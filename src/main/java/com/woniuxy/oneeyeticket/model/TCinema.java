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
 * 院线表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCinema implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "cinema_id", type = IdType.AUTO)
    private Integer cinemaId;

    /**
     * 院线名字
     */
    private String cinemaName;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 院线位置
     */
    private String cinemaPosition;
    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}
