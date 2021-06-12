package com.woniuxy.oneeyeticket.service;

import com.woniuxy.oneeyeticket.dao.TCinemaMapper;
import com.woniuxy.oneeyeticket.model.TCinema;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.oneeyeticket.model.TshowFrom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 院线表 服务类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface ITCinemaService extends IService<TCinema> {
    /**
     * 查询所有院线
     * @return
     */
    public List<TshowFrom> queryTCinema(Integer movieId,Integer areaId,String cinemaName);

    /**
     * 根据院线id查询电影院
     * @param cinemaId
     * @return
     */
    public List<TshowFrom> queryTCinemaById(Integer cinemaId,Integer movieId);

//    /**
//     * 根据前端传来的名字查询出院线详情
//     * @param cinemaName
//     * @return
//     */
//    public List<TCinema> queryTCinemaByName(String cinemaName);
}
