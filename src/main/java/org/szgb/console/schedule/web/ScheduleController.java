package org.szgb.console.schedule.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.schedule.entity.Schedule;
import org.szgb.console.schedule.mapper.ScheduleMapper;
import org.szgb.console.schedule.service.ScheduleService;
import org.szgb.core.base.web.BaseController;
import org.szgb.core.utils.AjaxJson;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends BaseController<ScheduleService, ScheduleMapper, Schedule> {

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        super(scheduleService);
    }

    @GetMapping("/export")
    public AjaxJson export(@RequestBody Schedule schedule, HttpServletRequest request, HttpServletResponse response) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", URLEncoder.encode("fileName", StandardCharsets.UTF_8));
        wb.write(response.getOutputStream());
        return null;
    }
}
