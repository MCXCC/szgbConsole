package org.szgb.console.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询参数类
 *
 * @param <T> 泛型类型，表示列表中的元素类型
 */
@Data
public class Page<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 查询结果的总记录数
     */
    private Integer count;

    /**
     * 当前页码
     */
    @JsonIgnore
    private Integer pageNo;

    /**
     * 每页显示的记录数
     */
    @JsonIgnore
    private Integer pageSize;

    /**
     * 数据库查询的起始位置（通常用于分页查询）
     */
    @JsonIgnore
    private Integer first;

    /**
     * 数据库查询的结束位置（通常用于分页查询）
     */
    @JsonIgnore
    private Integer last;

    /**
     * 查询结果的列表
     */
    private List<T> list = new ArrayList<>();

    /**
     * 排序条件
     */
    @JsonIgnore
    private String orderBy;
}
