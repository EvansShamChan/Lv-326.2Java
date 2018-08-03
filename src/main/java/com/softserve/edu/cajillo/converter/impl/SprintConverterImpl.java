package com.softserve.edu.cajillo.converter.impl;

import com.softserve.edu.cajillo.converter.SprintConverter;
import com.softserve.edu.cajillo.dto.SprintDto;
import com.softserve.edu.cajillo.entity.Sprint;
import com.softserve.edu.cajillo.service.impl.SprintServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SprintConverterImpl implements SprintConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SprintServiceImpl sprintService;

    @Override
    public Sprint convertToEntity(SprintDto sprintDto) {
        Sprint sprint = modelMapper.map(sprintDto, Sprint.class);
        sprint.setBoard(sprintService.getSprint(sprintDto.getBoardId()).getBoard());
        return sprint;
    }

    @Override
    public SprintDto convertToDto(Sprint sprint) {
        SprintDto sprintDto = modelMapper.map(sprint, SprintDto.class);
        sprintDto.setBoardId(sprint.getBoard().getId());
        return sprintDto;
    }
}
