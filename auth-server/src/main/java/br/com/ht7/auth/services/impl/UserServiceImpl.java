package br.com.ht7.auth.services.impl;

import br.com.ht7.auth.dtos.UserDTO;
import br.com.ht7.auth.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO getByEmail(String email, String password) {
        //TODO: buscar no microservice de User

        UserDTO user = new UserDTO();

        user.setEmail("ht7.mobile@gmail.com");
        user.setPassword("1234");
        user.setRole("ROLE_USER");

        return user;
    }
}
