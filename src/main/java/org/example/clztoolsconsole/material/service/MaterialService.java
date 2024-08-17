package org.example.clztoolsconsole.material.service;

import org.example.clztoolsconsole.material.entity.Material;
import org.example.clztoolsconsole.material.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialMapper materialMapper;

    @Autowired
    public MaterialService(MaterialMapper materialMapper){
        this.materialMapper = materialMapper;
    }

    public List<Material> findList(){
        return materialMapper.findList();
    }
}
