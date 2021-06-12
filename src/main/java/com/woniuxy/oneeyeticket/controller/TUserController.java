package com.woniuxy.oneeyeticket.controller;


import com.woniuxy.oneeyeticket.commom.Result;
import com.woniuxy.oneeyeticket.controller.from.LogFrom;
import com.woniuxy.oneeyeticket.controller.from.RegisterFrom;
import com.woniuxy.oneeyeticket.dao.TUserMapper;
import com.woniuxy.oneeyeticket.model.TUser;
import com.woniuxy.oneeyeticket.service.ITUserService;
import com.woniuxy.oneeyeticket.service.impl.TUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.ResultSet;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@RestController
@Slf4j
public class TUserController {
    @Autowired
    private ITUserService userService;
    /**
     * 登录功能
     * @param user
     * @return 是否登录成功
     */
    @GetMapping ("login")
    public Result login(@Valid LogFrom user){
        log.info("用户名{},密码{}",user.getUsername(),user.getPassword());
//        从前端获得用户名和密码，查询数据库
            TUser tUser = userService.login(user);
            if(tUser!=null){
//                将查询出的对象返回前端页面
                return Result.success(tUser);
            }else {
                return Result.fail("登录失败");
            }
    }

    @PostMapping("register")
    public Result register(@RequestBody RegisterFrom from){
        TUser tUser = new TUser();
        log.info("返回值1{}",from);
        BeanUtils.copyProperties(from,tUser);
        userService.insert(tUser);
        log.info("返回值2{}",tUser);
        return Result.success();
    }


}

