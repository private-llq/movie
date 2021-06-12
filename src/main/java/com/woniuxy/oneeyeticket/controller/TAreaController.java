package com.woniuxy.oneeyeticket.controller;


import com.woniuxy.oneeyeticket.commom.Result;
import com.woniuxy.oneeyeticket.model.TArea;
import com.woniuxy.oneeyeticket.service.ITAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 区 前端控制器
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@RestController
public class TAreaController {
    @Autowired
    private ITAreaService tAreaService;

    /**
     * 查询所有地区
     * @return
     */
    @GetMapping("queryArea")
    public Result queryArea(){

        List<TArea> tAreas = tAreaService.queryTarea();

        return Result.success(tAreas);
    }

}

