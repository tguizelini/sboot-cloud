package br.com.ht7.auth.services.impl;

import br.com.ht7.auth.dtos.UserDTO;
import br.com.ht7.auth.services.AuthService;
import br.com.ht7.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO user = userService.getByEmail("ht7.mobile@gmail.com", "1234");
        return validateUser(email, user);
    }

    @Override
    public UserDetails validateUser(String email, UserDTO user) {
        UserDetails userDetails = null;

        if(user!=null) {
            List<GrantedAuthority> grants = new ArrayList<GrantedAuthority>();
            grants.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });

            boolean accountNonLocked = true;
            boolean enabledUser = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;

            userDetails = new org.springframework.security.core.userdetails.User(
                    email,
                    user.getPassword(),
                    enabledUser,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    grants
                );
        }

        return userDetails;
    }
}
