package com.proj.tasksscheduler.infrastructure.security;


import com.proj.tasksscheduler.business.dto.UserDTO;
import com.proj.tasksscheduler.infrastructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service // Anotação que registra essa classe como um componente de serviço no Spring
public class UserDetailsServiceImpl {
    @Autowired
    private UserClient client;


    public UserDetails loadUserData(String email, String token){

        UserDTO userDTO = client.searchUserByEmail(email, token);

        return org.springframework.security.core.userdetails.User
                .withUsername(userDTO.getEmail())  // Nome de login
                .password(userDTO.getPassword())   // Senha já criptografada
                .build();
    }

}
