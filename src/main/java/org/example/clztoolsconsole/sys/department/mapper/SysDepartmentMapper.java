package org.example.clztoolsconsole.sys.department.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysDepartmentMapper {
    List<SysDepartment> findList();
}
