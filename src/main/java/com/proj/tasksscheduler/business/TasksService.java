package com.proj.tasksscheduler.business;

import com.proj.tasksscheduler.business.dto.TasksDTO;
import com.proj.tasksscheduler.business.mapper.TaskUpdateConverter;
import com.proj.tasksscheduler.business.mapper.TasksConverter;
import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import com.proj.tasksscheduler.infrastructure.enums.StatusNotificationEnum;
import com.proj.tasksscheduler.infrastructure.exceptions.ResourceNotFoundException;
import com.proj.tasksscheduler.infrastructure.repository.TasksRepository;
import com.proj.tasksscheduler.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;
    private final TasksConverter tasksConverter;
    private final JwtUtil jwtUtil;
    private final TaskUpdateConverter taskUpdateConverter;

    public TasksDTO recordTasks(String token, TasksDTO tasksDTO) {
        String email = jwtUtil.extractEmailToken(token.substring(7));
        tasksDTO.setCreationDate(LocalDateTime.now());
        tasksDTO.setStatusNotificationEnum(StatusNotificationEnum.PENDING);
        tasksDTO.setUserEmail(email);
        TasksEntity entity = tasksConverter.toTaskEntity(tasksDTO);

        return tasksConverter.toTaskDTO(
                tasksRepository.save(entity));
    }

    public List<TasksDTO> searchTasksScheduledByPeriod(LocalDateTime initialDate, LocalDateTime finalDate) {
        return tasksConverter.toListTasksDTO(
                tasksRepository.findByEventDateBetween(initialDate, finalDate));
    }

    public List<TasksDTO> searchTasksByEmail(String token) {
        String email = jwtUtil.extractEmailToken(token.substring(7));
        List<TasksEntity> tasksEntityList = tasksRepository.findByUserEmail(email);

        return tasksConverter.toListTasksDTO(tasksEntityList);
    }

    public void deleteTaskById(String id) {
        try {
            tasksRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException
                    ("Error deleting task by id, id inexistent " + id, e.getCause());

        }
    }

    public TasksDTO changeStatus(StatusNotificationEnum status, String id) {
        try {
            TasksEntity entity = tasksRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Task not found " + id));
            entity.setStatusNotificationEnum(status);
            return tasksConverter.toTaskDTO(tasksRepository.save(entity));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Error changing task status " + e.getCause());
        }
    }

    public TasksDTO updateTasks(TasksDTO dto, String id){
        try {
            TasksEntity entity = tasksRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Task not found" + id));
            taskUpdateConverter.updateTasks(dto, entity);
            return tasksConverter.toTaskDTO(tasksRepository.save(entity));
        }catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Error changing task status " + e.getCause());
        }
    }

}