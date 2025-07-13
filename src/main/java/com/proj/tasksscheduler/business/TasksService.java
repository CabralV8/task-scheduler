package com.proj.tasksscheduler.business;

import com.proj.tasksscheduler.business.dto.TasksDTO;
import com.proj.tasksscheduler.business.mapper.TasksConverter;
import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import com.proj.tasksscheduler.infrastructure.enums.StatusNotificationEnum;
import com.proj.tasksscheduler.infrastructure.repository.TasksRepository;
import com.proj.tasksscheduler.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;
    private final TasksConverter tasksConverter;
    private final JwtUtil jwtUtil;
    public TasksDTO recordTasks(String token, TasksDTO tasksDTO){
        String email = jwtUtil.extractEmailToken(token.substring(7));
        tasksDTO.setCreationDate(LocalDateTime.now());
        tasksDTO.setStatusNotificationEnum(StatusNotificationEnum.PENDING);
        tasksDTO.setUserEmail(email);
        TasksEntity entity = tasksConverter.toTaskEntity(tasksDTO);

        return tasksConverter.toTaskDTO(
                tasksRepository.save(entity));
    }
}
