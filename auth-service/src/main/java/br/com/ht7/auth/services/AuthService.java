package br.com.ht7.auth.services;

import br.com.ht7.auth.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService  extends UserDetailsService {
    UserDetails validateUser(String email, UserDTO user);
}
