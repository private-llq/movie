package com.woniuxy.oneeyeticket.controller;


import com.woniuxy.oneeyeticket.commom.Result;
import com.woniuxy.oneeyeticket.model.TshowFrom;
import com.woniuxy.oneeyeticket.service.ITCinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 院线表 前端控制器
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Slf4j
@RestController
public class TCinemaController {
    @Autowired
    private ITCinemaService tCinemaSeServiceImpl;

    /**
     * 全部区域
     * @return
     */
    @GetMapping("Moviee")
    public Result queryCinema(Integer movieId,Integer areaId,String cinemaName){

        List<TshowFrom> tCinemas = tCinemaSeServiceImpl.queryTCinema(movieId,areaId,cinemaName);

        return Result.success(tCinemas);
    }

    /**
     * 点击影院查询影院
     * @param cinemaId
     * @return
     */
    @GetMapping("queryCinemaBycinemaId")
    public Result queryCinemaByAreaId(Integer cinemaId,Integer movieId){
        log.info("影院id{},电影id{}",cinemaId,movieId);
        List<TshowFrom> tCinemas = tCinemaSeServiceImpl.queryTCinemaById(cinemaId,movieId);

        return Result.success(tCinemas);
    }

//    /**
//     * 根据院线名称模糊查询出院线详情
//     * @param cinemaName
//     * @return
//     */
//    @GetMapping("queryCinemaByName")
//    public Result queryCinemaByName(String cinemaName){
//
//        List<TCinema> tCinemas = tCinemaSeServiceImpl.queryTCinemaByName(cinemaName);
//
//        return Result.success(tCinemas);
//    }

}

