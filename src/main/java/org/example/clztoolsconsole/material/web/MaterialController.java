package org.example.clztoolsconsole.material.web;

import org.example.clztoolsconsole.material.service.MaterialService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/material")
public class MaterialController {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/list")
    public AjaxJson getMaterialList() {
        return AjaxJson.success("操作成功").put(materialService.findList());
    }
}