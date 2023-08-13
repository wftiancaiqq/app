package com.wf.first.app.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T>{
    private Long total;
    private Integer page;

    private Integer pageSize;

    private List<T> rows;
}
