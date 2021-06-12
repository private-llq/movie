package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 编剧电影表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TWriterMovie implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "writer_movie_id", type = IdType.AUTO)
    private Integer writerMovieId;

    /**
     * 电影id
     */
    private Integer movieId;

    /**
     * 编剧id
     */
    private Integer writerId;


}
