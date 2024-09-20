package org.example.clztoolsconsole.material.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.clztoolsconsole.material.entity.Material;
import org.example.clztoolsconsole.material.service.MaterialService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.example.clztoolsconsole.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/list")
    public AjaxJson getMaterialList(@RequestBody Material material, HttpServletRequest request,
                                    HttpServletResponse response) {
        Page<Material> page = new Page<>();
        page.setList(materialService.findList());
        return AjaxJson.success(request, response).put("page", page);
    }
}