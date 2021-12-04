package br.com.franca.hrworker.api.controller;

import br.com.franca.hrworker.domain.model.Worker;
import br.com.franca.hrworker.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(path = "/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerRepository repository;

    @GetMapping
    public List<Worker> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Worker findById(@PathVariable Long id) {

/**
 * Acima de 1000 o ribbon lá do hr-payroll aborta a requisição para essa api
 */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository.findById(id).get();
    }
}
