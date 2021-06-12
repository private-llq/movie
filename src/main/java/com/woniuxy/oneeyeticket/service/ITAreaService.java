package com.woniuxy.oneeyeticket.service;

import com.woniuxy.oneeyeticket.model.TArea;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 区 服务类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
public interface ITAreaService extends IService<TArea> {
    /**
     * 查询地区
     * @return
     */
    public List<TArea> queryTarea();

}
