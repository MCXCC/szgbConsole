package org.szgb.console.schedule.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.schedule.entity.Schedule;
import org.szgb.console.schedule.mapper.ScheduleMapper;
import org.szgb.console.schedule.service.ScheduleService;
import org.szgb.console.utils.excel.ExportExcel;
import org.szgb.core.base.web.BaseController;
import org.szgb.core.utils.AjaxJson;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends BaseController<ScheduleService, ScheduleMapper, Schedule> {

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        super(scheduleService);
    }

    @GetMapping("/export")
    public AjaxJson export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 模拟查询数据
        Schedule schedule = new Schedule();
        schedule.setId(1);
        schedule = service.get(schedule);

        ExportExcel excel = new ExportExcel();
        excel.createSheet("排班表");
        excel.setCellAlignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        excel.createRow().createCell(schedule.getDepartment().getName() + "日排班表").mergeCells(0, 0, 0, 8);
        excel.createRow().createCell(schedule.getDate(), "yyyy年MM月dd日 EEEE");
        excel.setCurrentCellIndex(8).createCell("800M：" + schedule.getM800());
        excel.createRow().createCell("白班");
        excel.setCurrentCellIndex(2).createCell("领班", "班制", "工时", "人数", "人员", "应急分工");

        excel.write(response, "排班表");
        return null;
    }
}
