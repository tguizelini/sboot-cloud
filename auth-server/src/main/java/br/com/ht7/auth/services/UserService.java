package br.com.ht7.auth.services;

import br.com.ht7.auth.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDTO getByEmail(String email, String password);
}
