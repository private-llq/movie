package com.woniuxy.oneeyeticket.service.impl;

import com.woniuxy.oneeyeticket.model.TArea;
import com.woniuxy.oneeyeticket.dao.TAreaMapper;
import com.woniuxy.oneeyeticket.service.ITAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 区 服务实现类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Service
public class TAreaServiceImpl extends ServiceImpl<TAreaMapper, TArea> implements ITAreaService {

    @Autowired
    private TAreaMapper tAreaMapper;

    /**
     * 查询所有地区
     * @return
     */
    @Override
    public List<TArea> queryTarea() {
        List<TArea> tAreas = tAreaMapper.selectList(null);
        return tAreas;
    }

}
