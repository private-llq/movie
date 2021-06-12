package com.woniuxy.oneeyeticket.controller;

import com.woniuxy.oneeyeticket.dao.TUserMapper;
import com.woniuxy.oneeyeticket.model.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private TUserMapper userMapper;
    @GetMapping("query")
    public TUser queryUser(){
        TUser tUser = userMapper.selectById(1);
        return tUser;
    }
}
