package br.com.franca.hrpayroll.client.hrworker;

import br.com.franca.hrpayroll.dtos.WorkerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hrworker", url="${hr-worker.host}", path = "${hr-worker.path}")
public interface IHrWorkerClient {

    @GetMapping(path = "/{id}")
    WorkerDTO findById(@PathVariable Long id);

}
