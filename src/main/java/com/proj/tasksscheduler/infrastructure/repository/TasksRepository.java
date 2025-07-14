package com.proj.tasksscheduler.infrastructure.repository;

import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends MongoRepository<TasksEntity, String> {

    List<TasksEntity> findByEventDateBetween(LocalDateTime initialDate, LocalDateTime finalDate);

    List<TasksEntity> findByUserEmail(String email);

}
