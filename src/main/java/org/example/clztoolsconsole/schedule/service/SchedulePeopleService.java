package org.example.clztoolsconsole.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.SchedulePeople;
import org.example.clztoolsconsole.schedule.mapper.SchedulePeopleMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulePeopleService extends BaseService<SchedulePeopleMapper, SchedulePeople> {
    private final SchedulePeopleMapper schedulePeopleMapper;

    @Autowired
    public SchedulePeopleService(SchedulePeopleMapper schedulePeopleMapper) {
        super(schedulePeopleMapper);
        this.schedulePeopleMapper = schedulePeopleMapper;
    }
}
