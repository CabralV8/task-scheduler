package com.proj.tasksscheduler.business.mapper;

import com.proj.tasksscheduler.business.dto.TasksDTO;
import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TasksConverter {

    TasksEntity toTaskEntity(TasksDTO tasksDTO);

    TasksDTO toTaskDTO(TasksEntity tasksEntity);

}
