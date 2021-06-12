package com.woniuxy.oneeyeticket.service.impl;

import com.woniuxy.oneeyeticket.model.TComment;
import com.woniuxy.oneeyeticket.dao.TCommentMapper;
import com.woniuxy.oneeyeticket.service.ITCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements ITCommentService {

}
