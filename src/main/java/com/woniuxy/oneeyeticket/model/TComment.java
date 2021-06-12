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
 * 评论表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TComment implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 电影表id
     */
    private Integer movieId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 评论
     */
    private String content;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}
