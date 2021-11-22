package br.com.franca.hrworker.api.controller;

import br.com.franca.hrworker.domain.model.Worker;
import br.com.franca.hrworker.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/works")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerRepository repository;

    @GetMapping
    public List<Worker> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Worker findById(@PathVariable Long id){
        return repository.findById(id).get();
    }
}
