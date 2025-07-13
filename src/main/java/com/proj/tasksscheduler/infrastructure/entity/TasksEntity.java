package com.proj.tasksscheduler.infrastructure.entity;

import com.proj.tasksscheduler.infrastructure.enums.StatusNotificationEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("task")
public class TasksEntity {

    @Id
    private String id;
    private String taskName;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime eventeDate;
    private String userEmail;
    private LocalDateTime alterationDate;
    private StatusNotificationEnum statusNotificationEnum;
}
