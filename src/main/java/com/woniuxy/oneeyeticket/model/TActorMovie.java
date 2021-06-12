package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 演员电影表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TActorMovie implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "actor_movie", type = IdType.AUTO)
    private Integer actorMovie;

    /**
     * 电影id
     */
    private Integer movieId;

    /**
     * 演员id
     */
    private Integer actorId;


}
