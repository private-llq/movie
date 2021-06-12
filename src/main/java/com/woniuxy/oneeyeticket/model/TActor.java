package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 演员表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TActor implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 演员id
     */
    @TableId(value = "actor_id", type = IdType.AUTO)
    private Integer actorId;

    /**
     * 演员名字
     */
    private String actorName;

    /**
     * 演员照片
     */
    private String actorPhoto;

    /**
     * 演员详细信息
     */
    private String actorInformation;


}
