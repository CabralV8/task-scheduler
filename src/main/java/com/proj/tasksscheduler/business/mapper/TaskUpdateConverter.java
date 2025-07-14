package com.proj.tasksscheduler.business.mapper;

import com.proj.tasksscheduler.business.dto.TasksDTO;
import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdateConverter {

    void updateTasks(TasksDTO dto, @MappingTarget TasksEntity entity);

}
