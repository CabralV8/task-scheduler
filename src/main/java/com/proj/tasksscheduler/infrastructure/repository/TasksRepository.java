package com.proj.tasksscheduler.infrastructure.repository;

import com.proj.tasksscheduler.infrastructure.entity.TasksEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends MongoRepository<TasksEntity, String> {
}
