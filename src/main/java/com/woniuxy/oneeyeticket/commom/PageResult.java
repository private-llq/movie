package com.woniuxy.oneeyeticket.commom;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageResult<D> extends Result{

    /**
     * 总条数
     */
    private int totalCount;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 当前页
     */
    private int pageIdx;

    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 当前页内容
     */
    private List<D> content;

    public PageResult(int totalCount, int pageIdx, int pageSize, List<D> content) {
        this.totalCount = totalCount;
        this.pageCount = totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
        this.pageIdx = pageIdx;
        this.pageSize = pageSize;
        this.content = content;
    }
}
