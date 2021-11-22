package br.com.franca.hrworker.domain.repository;

import br.com.franca.hrworker.domain.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
