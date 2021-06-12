package com.woniuxy.oneeyeticket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.oneeyeticket.model.TSeat;
import com.woniuxy.oneeyeticket.dao.TSeatMapper;
import com.woniuxy.oneeyeticket.service.ITSeatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 座位信息 服务实现类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Service
@Slf4j
public class TSeatServiceImpl extends ServiceImpl<TSeatMapper, TSeat> implements ITSeatService {
    @Autowired
    private  TSeatMapper seatMapper;
    @Override
    public List<List> getList(int hallId) {
        List<List> list=new ArrayList<>();
        log.info("参数{}",hallId);
        int x=seatMapper.getMaxX(hallId);
        for (int i = 0; i <x ; i++) {
            List l1=new ArrayList();
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("seat_x",i+1);
            wrapper.eq("hall_id",hallId);
            wrapper.orderByAsc("seat_y");
            wrapper.select("status");
            List<TSeat> l=seatMapper.selectList(wrapper);
            for(TSeat s:l){
                l1.add(s.getStatus());
            }
            log.info("一行数据{}",l1);
            list.add(l1);
        }
        log.info("一行数据{}",list);
        return list;
    }
}
