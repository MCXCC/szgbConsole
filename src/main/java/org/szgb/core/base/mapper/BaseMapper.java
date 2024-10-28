package org.szgb.core.base.mapper;

import java.util.List;

public interface BaseMapper<T> {
    T get(int id);

    T get(T entity);

    List<T> findList(T entity);

    Integer getCount(T entity);

    void insert(T entity);

    void update(T entity);

    void delete(int id);

    void delete(T entity);
}
