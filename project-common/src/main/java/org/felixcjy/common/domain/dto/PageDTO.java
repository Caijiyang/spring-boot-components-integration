package org.felixcjy.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: Felix(蔡济阳)
 * @since : 2025/2/24 20:17
 */
@Data
@AllArgsConstructor
public class PageDTO<T> {
    /** 总条数 */
    private Long total;

    /** 总页数 */
    private Long pages;

    /** 分页结果集合 */
    private List<T> records;

    /** 单前页码 */
    private Long currentPage;

    /** 分页大小 */
    private Long pageSize;
}

