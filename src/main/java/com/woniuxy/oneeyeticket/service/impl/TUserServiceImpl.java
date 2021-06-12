package com.woniuxy.oneeyeticket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.oneeyeticket.controller.from.LogFrom;
import com.woniuxy.oneeyeticket.model.TUser;
import com.woniuxy.oneeyeticket.dao.TUserMapper;
import com.woniuxy.oneeyeticket.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    private TUserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return 用户
     */
    @Override
    public TUser login(LogFrom user) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
//        获取对象
        TUser tUser = userMapper.selectOne(queryWrapper);
        return tUser;
    }

    @Override
    public void insert(TUser user){
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());
        userMapper.insert(user);
    }

}
