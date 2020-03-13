package br.com.ht7.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    @GetMapping("/user")
    public Principal getUserDetail(Principal user) {
        return user;
    }
}
