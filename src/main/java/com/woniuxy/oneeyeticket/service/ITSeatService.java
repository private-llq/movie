package com.woniuxy.oneeyeticket.service;

import com.woniuxy.oneeyeticket.model.TSeat;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 座位信息 服务类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface ITSeatService extends IService<TSeat> {

    List<List> getList(int hallId);
}
