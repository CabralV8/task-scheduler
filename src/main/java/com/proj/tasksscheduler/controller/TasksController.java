package com.proj.tasksscheduler.controller;

import com.proj.tasksscheduler.business.TasksService;
import com.proj.tasksscheduler.business.dto.TasksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/events")
    public ResponseEntity<List<TasksDTO>> searchSchedulesListsByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime initialDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate){
        return ResponseEntity.ok(tasksService.searchTasksScheduledByPeriod(initialDate, finalDate));

    }

    @GetMapping
    public ResponseEntity<List<TasksDTO>> searchTasksByEmail(@RequestHeader("Authorization") String token){
        List<TasksDTO> tasks = tasksService.searchTasksByEmail(token);
        return ResponseEntity.ok(tasks);
    }

}
