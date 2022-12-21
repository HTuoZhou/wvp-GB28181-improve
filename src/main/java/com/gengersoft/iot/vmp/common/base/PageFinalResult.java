package com.gengersoft.iot.vmp.common.base;

import cn.hutool.core.util.PageUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author HTuoZhou
 */
@Data
public class PageFinalResult<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Integer totalCount;

    private Integer pageCount;

    private List<T> pageData;

    public PageFinalResult() {

    }

    public PageFinalResult(int pageNum, int pageSize, List<T> pageData) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;

        if (Objects.nonNull(pageData)) {
            this.totalCount = pageData.size();
            this.pageCount = PageUtil.totalPage(this.totalCount, this.pageSize);

            int start;
            int end;
            if (pageSize >= totalCount) {
                pageSize = totalCount;
            }
            if (pageNum < pageCount) {
                start = (pageNum - 1) * pageSize;
                end = start + pageSize;
            } else {
                pageNum = pageCount;
                start = (pageNum - 1) * pageSize;
                end = totalCount;
            }
            this.pageData = pageData.subList(start, end);
        } else {
            this.totalCount = 0;
            this.pageCount = 0;
            this.pageData = new ArrayList<>();
        }
    }

}
