package br.com.franca.hroauth.api.controller;

import br.com.franca.hroauth.domain.dtos.UserDTO;
import br.com.franca.hroauth.domain.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
//@RestController
//@RequestMapping(value = "/users")
//public class UserController {
//
//    private final UserService service;
//
//    @GetMapping(path = "/emails")
//    public UserDTO findByEmail(@RequestParam String email) {return service.findByEmail(email);}
//}
