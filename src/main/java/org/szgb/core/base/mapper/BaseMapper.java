package org.szgb.core.base.mapper;

import java.util.List;

public interface BaseMapper<T> {
    T get(String id);

    List<T> findList(T entity);

    Integer getCount(T entity);

    void insert(T entity);

    void update(T entity);

    void delete(String id);

    void delete(T entity);
}
