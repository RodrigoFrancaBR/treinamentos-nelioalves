package br.com.franca.hrworker.api.controller;

import br.com.franca.hrworker.domain.model.Worker;
import br.com.franca.hrworker.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(path = "/workers")
@Slf4j
@RequiredArgsConstructor
public class WorkerController {

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    private final WorkerRepository repository;

    @GetMapping
    public List<Worker> findAll(){
        System.out.println(testConfig);
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Worker findById(@PathVariable Long id){
        log.info("obtendo um trabalhador por id: {}", id);
        log.info("PORT: {}", env.getProperty("local.server.port"));
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
