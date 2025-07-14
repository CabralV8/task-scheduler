package com.proj.tasksscheduler.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.tasksscheduler.infrastructure.enums.StatusNotificationEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TasksDTO {

    private String id;
    private String taskName;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime eventDate;
    private String userEmail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime alterationDate;
    private StatusNotificationEnum statusNotificationEnum;
}
