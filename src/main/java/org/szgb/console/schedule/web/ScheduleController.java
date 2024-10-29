package org.szgb.console.schedule.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/export")
    public AjaxJson export(@RequestBody Schedule schedule, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 模拟查询数据
        System.out.println("schedule = " + schedule);
        Schedule schedule1 = new Schedule();
        schedule1.setId(1);
        schedule1 = service.get(schedule1);

        ExportExcel excel = new ExportExcel();
        excel.createSheet("排班表");
        excel.setCellAlignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        excel.createRow().mergeCells(1, 9).createCell(schedule1.getDepartment().getName() + "日排班表");
        excel.createRow().mergeCells(1, 2).createCell(schedule1.getDate(), "yyyy年MM月dd日 EEEE");
        excel.setCurrentCellIndex(2).mergeCells(1, 6);
        excel.setCurrentCellIndex(8).createCell("800M：" + schedule1.getM800());
        excel.createRow().mergeCells(3, 2).createCell("白班");
        excel.setCurrentCellIndex(2).createCell("领班", "班制", "工时", "人数", "人员", "应急分工");

        excel.write(response, "排班表");
        return null;
    }
}
