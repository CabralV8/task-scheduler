package com.proj.tasksscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TasksSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksSchedulerApplication.class, args);
	}

}
