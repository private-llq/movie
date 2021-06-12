package com.woniuxy.oneeyeticket.service;

import com.woniuxy.oneeyeticket.controller.from.LogFrom;
import com.woniuxy.oneeyeticket.model.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface ITUserService extends IService<TUser> {
    /**
     * 登录
     * @return 用户信息
     */
    public TUser login(LogFrom user);


    void insert(TUser tUser);
}
