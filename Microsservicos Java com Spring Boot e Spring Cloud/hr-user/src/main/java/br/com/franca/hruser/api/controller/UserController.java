package br.com.franca.hruser.api.controller;

import br.com.franca.hruser.domain.model.User;
import br.com.franca.hruser.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserRepository repository;

    @GetMapping(path = "/{id}")
    public User findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping(path = "/emails")
    public User findByEmail(@RequestParam String email) {
        log.info("email: {}", email);
        return repository.findByEmail(email);
    }
}
