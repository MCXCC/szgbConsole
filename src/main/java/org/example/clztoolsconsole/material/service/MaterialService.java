package org.example.clztoolsconsole.material.service;

import org.example.clztoolsconsole.material.entity.Material;
import org.example.clztoolsconsole.material.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    public List<Material> findList(){
        return materialMapper.findList();
    }
}
