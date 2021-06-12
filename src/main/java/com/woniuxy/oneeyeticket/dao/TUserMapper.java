package com.woniuxy.oneeyeticket.dao;

import com.woniuxy.oneeyeticket.model.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */

public interface TUserMapper extends BaseMapper<TUser> {

}
