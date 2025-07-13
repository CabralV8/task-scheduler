package com.proj.tasksscheduler.controller;

import com.proj.tasksscheduler.business.TasksService;
import com.proj.tasksscheduler.business.dto.TasksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;

    @PostMapping
    public ResponseEntity<TasksDTO> recordTasks(@RequestBody TasksDTO tasksDTO,
                                                @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tasksService.recordTasks(token, tasksDTO));
    }

}
