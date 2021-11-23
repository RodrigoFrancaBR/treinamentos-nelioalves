package br.com.franca.hrpayroll.domain.service;

import br.com.franca.hrpayroll.domain.model.Payment;
import br.com.franca.hrpayroll.dtos.WorkerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;
    private String path = "/workers/{id}";

    public Payment getPayment(long workerId, int days) {
        log.info("obtendo um pagamento por worker id: {} com dias trabalhados: {}", workerId, days);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", Long.toString(workerId));

        WorkerDTO dto = restTemplate.getForObject(workerHost + path, WorkerDTO.class, uriVariables);
        return new Payment(dto.getName(), dto.getDailyIncome(), days);
    }
}
