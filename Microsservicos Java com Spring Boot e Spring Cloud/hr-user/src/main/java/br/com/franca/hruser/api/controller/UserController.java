package br.com.franca.hruser.api.controller;

import br.com.franca.hruser.domain.model.User;
import br.com.franca.hruser.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserRepository repository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path = "/{id}/emails")
    public ResponseEntity<User> findById(@PathVariable Long id,  @RequestParam(required = false) String email) {
        System.out.println(id);
        System.out.println(email);
        User obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}
