package org.felixcjy.common.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.felixcjy.common.domain.enums.ErrorType;

import java.io.Serializable;

/**
 * 通用 HTTP 响应封装类
 * PS：这是个模板，通常用不到 PageInfo 因为有 IPage
 *
 * @param <T> 响应数据的类型
 * @author: Felix(蔡济阳)
 * @since : 2025/2/23 16:36
 */
@Data
public class WebResultTemplate<T> implements Serializable {
    // 核心字段
    private int code;       // 状态码（自定义或 HTTP 状态码）
    private String message; // 提示消息
    private T data;         // 业务数据
    private long timestamp; // 时间戳（自动生成）

    // 可选扩展字段（如分页信息）
    private PageInfo page;  // 分页信息（可选）

    /**
     * 分页信息封装类
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PageInfo {
        private int pageNum;   // 当前页
        private int pageSize;  // 每页大小
        private long total;    // 总条数
    }

    // ---------------------- 核心构造方法 ----------------------
    private WebResultTemplate() {
        this.timestamp = System.currentTimeMillis();
    }

    // ---------------------- 静态工厂方法（推荐入口） ----------------------

    /**
     * 成功响应（无数据）
     */
    public static <T> WebResultTemplate<T> success() {
        return success(null);
    }

    /**
     * 成功响应（带数据）
     */
    public static <T> WebResultTemplate<T> success(T data) {
        WebResultTemplate<T> result = new WebResultTemplate<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    /**
     * 失败响应（自定义状态码和消息）
     */
    public static <T> WebResultTemplate<T> fail(int code, String message) {
        WebResultTemplate<T> result = new WebResultTemplate<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败响应（预定义错误类型，如业务异常）
     */
    public static <T> WebResultTemplate<T> fail(ErrorType errorType) {
        return fail(errorType.getCode(), errorType.getMessage());
    }

    // ---------------------- 链式方法（可选） ----------------------

    /**
     * 链式设置分页信息
     */
    public WebResultTemplate<T> withPage(int pageNum, int pageSize, long total) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(total);
        this.page = pageInfo;
        return this;
    }

    /**
     * 链式设置自定义消息
     */
    public WebResultTemplate<T> withMessage(String message) {
        this.message = message;
        return this;
    }
}