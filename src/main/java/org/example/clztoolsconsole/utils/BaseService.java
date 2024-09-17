package org.example.clztoolsconsole.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<M extends BaseMapper<T>, T extends BeanEntity<T>> {
    protected M mapper;

    @Autowired
    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T get(T entity) {
        return mapper.get(entity);
    }

    public T get(int id) {
        return mapper.get(id);
    }

    public List<T> findList(T entity) {
        return mapper.findList(entity);
    }

    public Integer getCount(T entity) {
        return mapper.getCount(entity);
    }

    public void save(T entity) {
        if (entity.getId() != null) {
            entity.setCreatedBy(entity.getUpdatedBy());
            mapper.update(entity);
        } else {
            mapper.insert(entity);
        }
    }
}
