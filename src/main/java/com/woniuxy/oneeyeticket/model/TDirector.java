package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 导演表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDirector implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 导演id
     */
    @TableId(value = "director_id", type = IdType.AUTO)
    private Integer directorId;

    /**
     * 导演名字
     */
    private String directorName;


}
