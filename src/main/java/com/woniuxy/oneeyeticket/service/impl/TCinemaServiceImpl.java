package com.woniuxy.oneeyeticket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.oneeyeticket.model.TCinema;
import com.woniuxy.oneeyeticket.dao.TCinemaMapper;
import com.woniuxy.oneeyeticket.model.TshowFrom;
import com.woniuxy.oneeyeticket.service.ITCinemaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 院线表 服务实现类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Service
@Slf4j
public class TCinemaServiceImpl extends ServiceImpl<TCinemaMapper, TCinema> implements ITCinemaService {

    @Autowired
    private TCinemaMapper tCinemaMapper;

    /**
     * 查询所有院线信息
     * @return 院线信息集合
     */
//    @Cacheable(value="Cinema_cache")
    @Override
    public List<TshowFrom> queryTCinema(Integer movieId,Integer areaId,String cinemaName) {
        List<TshowFrom> tshowFroms = tCinemaMapper.queryCinema(movieId,areaId,cinemaName);
        log.info("从数据库中查询地区={}",tshowFroms);
        return tshowFroms;
    }

    /**
     * 根据id查询院线信息
     * @param cinemaId
     * @return 院线信息
     */

    @Override
    public List<TshowFrom> queryTCinemaById(Integer cinemaId,Integer movieId) {


        List list = tCinemaMapper.queryCinemaById(cinemaId,movieId);
        return list;
    }
//    /**
//     * 根据前端传来的名字查询出院线详情
//     * @param cinemaName
//     * @return
//     */
//    @Override
//    public List<TCinema> queryTCinemaById(String cinemaName) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like("cinema_name",cinemaName);
//        List list = tCinemaMapper.selectList(queryWrapper);
//        return list;
//    }

}
