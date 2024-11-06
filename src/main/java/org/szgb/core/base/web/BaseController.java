package org.szgb.core.base.web;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.console.utils.Page;
import org.szgb.console.utils.TokenUtil;
import org.szgb.core.base.entity.BeanEntity;
import org.szgb.core.base.mapper.BaseMapper;
import org.szgb.core.base.service.BaseService;
import org.szgb.core.utils.AjaxJson;

public abstract class BaseController<S extends BaseService<M, T>, M extends BaseMapper<T>, T extends BeanEntity<T>> {
    protected S service;

    public BaseController(S service) {
        this.service = service;
    }

    /**
     * 处理POST请求以获取实体对象
     *
     * @param entity   请求体中的实体对象，用于查询
     * @param request  HTTP请求对象，用于获取请求信息
     * @param response HTTP响应对象，用于设置响应信息
     * @return 返回一个AjaxJson对象，包含查询结果或错误信息
     */
    @PostMapping("/get")
    public AjaxJson get(@RequestBody T entity, HttpServletRequest request, HttpServletResponse response) {
        // 调用服务层方法，根据实体对象获取单个实体对象
        T t = service.get(entity);
        // 如果实体对象为空，则返回错误响应
        if (t == null) {
            return AjaxJson.error("数据不存在", HttpStatus.HTTP_NOT_FOUND, request, response);
        }
        // 返回成功的响应，并将实体对象放入响应中
        return AjaxJson.success(request, response).put("data", t);
    }

    /**
     * 处理POST请求，根据给定的实体获取列表并返回
     *
     * @param entity   用于查询的实体对象
     * @param request  HTTP请求对象
     * @param response HTTP响应对象
     * @return 包含查询结果和分页信息的AjaxJson对象
     */
    @PostMapping("/list")
    public AjaxJson getList(@RequestBody T entity, HttpServletRequest request, HttpServletResponse response) {
        // 创建一个Page对象，用于分页显示
        Page<T> page = new Page<>();

        // 如果实体对象的ID不为空，则直接调用get方法获取单个实体对象
        if (entity.getId() != null) {
            return this.get(entity, request, response);
        }

        // 设置Page对象的列表属性，包含根据实体对象查询到的数据
        page.setList(service.findList(entity));
        // 设置Page对象的总记录数属性，用于分页显示
        page.setCount(service.getCount(entity));
        // 创建一个成功的AjaxJson对象，并放入Page对象，以便于前端展示
        return AjaxJson.success(request, response).put("page", page);
    }

    /**
     * 通过POST请求保存实体对象
     *
     * @param entity   待保存的实体对象，通过请求体传入
     * @param request  HTTP请求对象，用于获取请求信息
     * @param response HTTP响应对象，用于设置响应信息
     * @return 返回一个AjaxJson对象，表示保存操作的结果
     * 该方法主要用于保存或更新一个实体对象，它会根据当前用户信息和业务规则对实体进行处理，
     * 然后调用服务层的save方法尝试保存实体。保存成功或失败的信息将通过AjaxJson对象返回。
     */
    @PostMapping("/save")
    public AjaxJson save(@RequestBody T entity, HttpServletRequest request, HttpServletResponse response) {
        if (entity == null) {
            return AjaxJson.error("参数错误", HttpStatus.HTTP_BAD_REQUEST, request, response);
        }
        // 创建一个系统用户对象，用于存储当前操作用户的信息
        SysUser sysUser = new SysUser();
        // 从请求中提取当前用户的ID，并设置到用户对象
        sysUser.setId(TokenUtil.getUid(request));
        // 设置实体对象的更新者为当前用户
        entity.setUpdatedBy(sysUser);
        // 调用服务层的save方法，尝试保存或更新实体对象，返回保存结果的Map
        entity = service.save(entity);
        if (entity == null) {
            return AjaxJson.error("保存失败", HttpStatus.HTTP_NOT_FOUND, request, response);
        }
        // 根据保存结果返回相应的AjaxJson对象
        return AjaxJson.success("保存成功", request, response).put("data", entity);
    }

    /**
     * 处理删除请求，通过传入的ID字符串删除相应的数据
     *
     * @param ids      多个数据的ID，以逗号分隔，用于标识需要删除的数据
     * @param request  HTTP请求对象，用于访问请求属性等信息
     * @param response HTTP响应对象，用于发送响应信息给客户端
     * @return 返回AjaxJson对象，表示删除操作的结果
     */
    @DeleteMapping("/delete")
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        // 检查ID参数是否为空，为空则返回错误响应
        if (ids == null) {
            return AjaxJson.error("参数错误", HttpStatus.HTTP_BAD_REQUEST, request, response);
        }
        // 调用服务层方法，执行删除操作
        service.delete(ids);
        // 返回成功响应
        return AjaxJson.success(request, response);
    }
}
