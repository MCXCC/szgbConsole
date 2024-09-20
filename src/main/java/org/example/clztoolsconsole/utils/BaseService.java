package org.example.clztoolsconsole.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public abstract class BaseService<M extends BaseMapper<T>, T extends BeanEntity<T>> {
    protected M mapper;

    @Autowired
    public BaseService(M mapper) {
        this.mapper = mapper;
    }

    public T get(T entity) {
        return mapper.get(entity);
    }

    public T get(int id) {
        return mapper.get(id);
    }

    public List<T> findList(T entity) {
        Page<T> page = entity.getPage();
        page.setFirst((page.getPageNo()-1)*page.getPageSize());
        entity.setPage(page);
        return mapper.findList(entity);
    }

    public Integer getCount(T entity) {
        return mapper.getCount(entity);
    }

    public Map<Boolean,String> save(T entity) {
        if (entity.getId() == null) {
            entity.setCreatedBy(entity.getUpdatedBy());
            mapper.insert(entity);
            return Map.of(true,"新增成功");
        } else {
            T t = mapper.get(entity);
            if (!Objects.equals(t.getVersion(), entity.getVersion())){
                return Map.of(false,"数据版本冲突，请刷新后重试");
            }
            mapper.update(entity);
            return Map.of(true,"修改成功");
        }
    }

    public void delete(int id) {
        mapper.delete(id);
    }

    public void delete(T entity) {
        mapper.delete(entity);
    }

    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            mapper.delete(Integer.parseInt(s));
        }
    }
}
