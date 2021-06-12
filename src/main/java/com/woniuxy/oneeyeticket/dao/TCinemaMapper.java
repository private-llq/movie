package com.woniuxy.oneeyeticket.dao;

import com.woniuxy.oneeyeticket.model.TCinema;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.oneeyeticket.model.TshowFrom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 院线表 Mapper 接口
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface TCinemaMapper extends BaseMapper<TCinema> {

    /**
     * 查询所有院线信息
     * @param movieId
     * @return
     */
     List<TshowFrom> queryCinema(@Param("movieId") Integer movieId,@Param("areaId") Integer areaId,@Param("cinemaName") String cinemaName);

    /**
     * 根据id查询院线
     * @param cinemaId
     * @return
     */
     List<TshowFrom> queryCinemaById(@Param("cinemaId")Integer cinemaId,@Param("movieId")Integer movieId);
}
