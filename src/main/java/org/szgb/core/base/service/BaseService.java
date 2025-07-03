package org.szgb.core.base.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.utils.Page;
import org.szgb.core.base.entity.BeanEntity;
import org.szgb.core.base.mapper.BaseMapper;

import java.util.List;
import java.util.Objects;

@Slf4j
public abstract class BaseService<M extends BaseMapper<T>, T extends BeanEntity<T>> {
    protected final M mapper;

    public BaseService(M mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public T get(T entity) {
        return get(entity.getId());
    }

    @Transactional(readOnly = true)
    protected T get(int id) {
        return mapper.get(id);
    }

    @Transactional(readOnly = true)
    public List<T> findList(T entity) {
        if (entity!=null && entity.getPage() != null) {
            Page<T> page = entity.getPage();
            page.setFirst((page.getPageNo() - 1) * page.getPageSize());
            entity.setPage(page);
        }
        return mapper.findList(entity);
    }

    @Transactional(readOnly = true)
    public Integer getCount(T entity) {
        return mapper.getCount(entity);
    }

    /**
     * 保存实体对象
     * 如果实体对象的ID为null，则视为新实体进行插入操作
     * 如果实体对象的ID不为null，则视为现有实体进行更新操作，但需检查数据版本是否冲突
     *
     * @param entity 要保存的实体对象，类型为泛型T
     * @return 返回一个Map对象，键为Boolean表示操作是否成功，值为String表示操作的结果信息
     */
    @Transactional(readOnly = false)
    public T save(T entity) {
        // 检查实体对象的ID是否为null，判断是否为新实体
        if (entity.getId() == null) {
            // 对于新实体，设置创建者信息
            entity.setCreatedBy(entity.getUpdatedBy());
            // 执行插入操作
            mapper.insert(entity);
            // 返回成功插入的信息
        } else {
            // 对于现有实体，根据ID获取数据库中的实体对象
            T t = get(entity);
            // 检查数据版本是否冲突
            if (!Objects.equals(t.getVersion(), entity.getVersion())) {
                // 如果数据版本冲突，返回错误信息
                return null;
            }
            // 更新实体的数据版本
            entity.setVersion(entity.getVersion() + 1);
            // 执行更新操作
            mapper.update(entity);
            // 返回成功更新的信息
        }
        return entity;
    }

    /**
     * 根据多个ID删除实体
     * <p>
     * 此方法使用了@Transactional注解，确保整个删除操作是事务性的，即要么全部删除成功，要么全部失败
     * 这是为了维护数据的一致性和完整性
     *
     * @param ids 一个包含多个ID的字符串，ID之间用逗号分隔
     */
    @Transactional(readOnly = false)
    public void delete(String ids) {
        // 将输入的ID字符串按逗号分割成单个ID的数组
        String[] id = ids.split(",");
        // 遍历每个ID，逐个执行删除操作
        for (String s : id) {
            // 将字符串ID转换为整数，并调用mapper的删除方法进行删除
            delete(Integer.parseInt(s));
        }
    }

    @Transactional(readOnly = false)
    protected void delete(int id) {
        mapper.delete(id);
    }

    @Transactional(readOnly = false)
    protected void delete(T entity) {
        delete(entity.getId());
    }

    /**
     * 删除实体列表
     * <p>
     * 此方法标记为@Transactional(readOnly = false)，表示它是一个事务性操作，会修改数据库中的数据
     * 它通过循环遍历实体列表，对每个实体调用mapper的delete方法进行删除操作
     *
     * @param entityList 待删除的实体列表，包含了一个或多个实体对象
     */
    @Transactional(readOnly = false)
    protected void delete(List<T> entityList) {
        for (T entity : entityList) {
            delete(entity);
        }
    }
}
