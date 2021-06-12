package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 编剧表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TWriter implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编剧id
     */
    @TableId(value = "writer_id", type = IdType.AUTO)
    private Integer writerId;

    /**
     * 编剧名字
     */
    private String writerName;


}
