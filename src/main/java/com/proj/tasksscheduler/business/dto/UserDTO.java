package com.proj.tasksscheduler.business.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String email;
    private String password;


}
