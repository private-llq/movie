package com.woniuxy.oneeyeticket.dao;

import com.woniuxy.oneeyeticket.model.TOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface TOrderMapper extends BaseMapper<TOrder> {
    @Select("select * from t_order where user_id = #{userId}")
    List<TOrder> selectOrderByStatus(Integer userId);
}
