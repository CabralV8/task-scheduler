package com.proj.tasksscheduler.controller;

import com.proj.tasksscheduler.business.TasksService;
import com.proj.tasksscheduler.business.dto.TasksDTO;
import com.proj.tasksscheduler.infrastructure.enums.StatusNotificationEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;

    @PostMapping
    public ResponseEntity<TasksDTO> recordTasks(@RequestBody TasksDTO tasksDTO,
                                                @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tasksService.recordTasks(token, tasksDTO));
    }

    @GetMapping("/events")
    public ResponseEntity<List<TasksDTO>> searchSchedulesListsByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime initialDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate) {
        return ResponseEntity.ok(tasksService.searchTasksScheduledByPeriod(initialDate, finalDate));

    }

    @GetMapping
    public ResponseEntity<List<TasksDTO>> searchTasksByEmail(@RequestHeader("Authorization") String token) {
        List<TasksDTO> tasks = tasksService.searchTasksByEmail(token);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTaskById(@RequestParam("id") String id) {
        tasksService.deleteTaskById(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TasksDTO> changeStatusNotification(@RequestParam("status") StatusNotificationEnum status,
                                                             @RequestParam("id") String id) {
        return ResponseEntity.ok(tasksService.changeStatus(status, id));
    }

    @PutMapping
    public ResponseEntity<TasksDTO> updateTasks(@RequestBody TasksDTO dto, @RequestParam("id") String id){
        return ResponseEntity.ok(tasksService.updateTasks(dto, id));
    }

}
