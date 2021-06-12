package com.woniuxy.oneeyeticket.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.oneeyeticket.commom.PageResult;
import com.woniuxy.oneeyeticket.commom.Result;
import com.woniuxy.oneeyeticket.model.TMovie;
import com.woniuxy.oneeyeticket.model.TShowmovie;
import com.woniuxy.oneeyeticket.service.ITMovieService;
import com.woniuxy.oneeyeticket.service.ITShowmovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 电影信息 前端控制器
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@RestController
@Slf4j
@CrossOrigin
public class TMovieController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ITMovieService service;
    @GetMapping("index")
    public Result getIndex(){
        QueryWrapper<TMovie> wrapper=new QueryWrapper();
        wrapper.eq("status","onshow");
        List<TMovie> list = service.list(wrapper);

//        HashOperations hash = redisTemplate.opsForHash();
//        for (TMovie m : list) {
//            Map map=new HashMap<String, String>();
//            map.put("id",m.getMovieId());
//            map.put("year",m.getYear());
//            map.put("title",m.getTitle());
//            map.put("poster",m.getPoster());
//            map.put("summary",m.getSummary());
//            map.put("languages",m.getLanguages());
//            map.put("duration",m.getLanguages());
//            map.put("status",m.getStatus());
//
//
//            hash.putAll(m.getMovieId(),map);
//        }
        return Result.success(list);



    }
//    @GetMapping("movie/{id}")
//    public  Result movie(@PathVariable("id") String movieId){
//        log.info("参数{}",movieId);
//        HashOperations hash = redisTemplate.opsForHash();
//        Map map = hash.entries(movieId);
//        TMovie movie=new TMovie();
//        movie.setMovieId(Integer.parseInt(movieId));
//        movie.setYear((String) map.get("year"));
//        movie.setTitle((String) map.get("title"));
//        movie.setPoster((String) map.get("poster"));
//        movie.setSummary((String) map.get("summary"));
//        movie.setLanguages((String) map.get("languages"));
//        movie.setDuration((Integer) map.get("duration"));
//        movie.setStatus((String) map.get("status"));
//        return Result.success(movie);
//    }


}

