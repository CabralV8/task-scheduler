package com.proj.tasksscheduler.business.mapper;

import com.proj.tasksscheduler.business.dto.TasksDTO;
import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TasksConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "eventDate", target = "eventDate")
    @Mapping(source = "creationDate", target = "creationDate")
    TasksEntity toTaskEntity(TasksDTO tasksDTO);

    TasksDTO toTaskDTO(TasksEntity tasksEntity);

    List<TasksEntity> toListTasksEntity(List<TasksDTO> tasksDTOS);

    List<TasksDTO> toListTasksDTO(List<TasksEntity> tasksEntities);

}
