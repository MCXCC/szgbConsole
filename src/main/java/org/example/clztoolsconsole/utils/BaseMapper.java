package org.example.clztoolsconsole.utils;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseMapper <T>{
    public T get(int id);
    public T get(T entity);
    public List<T> findList(T entity);
    public Integer getCount(T entity);
    public void insert(T entity);
    public void update(T entity);
}
