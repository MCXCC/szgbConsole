package org.example.clztoolsconsole.material.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.material.entity.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MaterialMapper {
    List<Material> findList();
}
