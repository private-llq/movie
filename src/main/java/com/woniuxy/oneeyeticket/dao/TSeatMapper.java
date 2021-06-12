package com.woniuxy.oneeyeticket.dao;

import com.woniuxy.oneeyeticket.model.TSeat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 座位信息 Mapper 接口
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Component
public interface TSeatMapper extends BaseMapper<TSeat> {
    @Select("SELECT MAX(seat_x) FROM t_seat WHERE hall_id=#{hallId}")
    int getMaxX(int hallId);
    @Select("SELECT status FROM t_seat where seat_x=#{seatX} and hall_id=#{hallId} ORDER BY seat_y")
    List<String> getStatus(@Param("seatX")int seatX,@Param("hallId") int hallId);
}
