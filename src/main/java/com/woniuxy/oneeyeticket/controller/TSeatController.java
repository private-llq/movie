package com.woniuxy.oneeyeticket.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.woniuxy.oneeyeticket.commom.Result;
import com.woniuxy.oneeyeticket.controller.from.SeatForm;
import com.woniuxy.oneeyeticket.service.ITSeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 座位信息 前端控制器
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@RestController
@CrossOrigin
@Slf4j
public class TSeatController {
    @Autowired
    private ITSeatService seatService;
    @GetMapping("seats/{id}")
    private List<List>  getSeat(@PathVariable("id") int hallId){
        List<List> list=seatService.getList(hallId);
        return  list;
    };
    @PutMapping("updseats")
    private Result updseats(@RequestParam(value = "msg") String[] msg){
        log.info("{}", Arrays.toString(msg));
        String s = Arrays.toString(msg);

        s=s.substring(1,s.length()-1);

        String[] split = s.split(", ");

        for (int i = 0; i <split.length/2 ; i++) {
            UpdateWrapper wrapper=new UpdateWrapper();
            wrapper.eq("seat_x",Integer.parseInt(split[2*i])+1);
            wrapper.eq("seat_y",Integer.parseInt(split[2*i+1])+1);
            wrapper.set("status",2);
            seatService.update(wrapper);
        }
        return Result.success();
    }
}

