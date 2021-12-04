package br.com.franca.hrpayroll.domain.service;

import br.com.franca.hrpayroll.client.hrworker.IHrWorkerClient;
import br.com.franca.hrpayroll.domain.model.Payment;
import br.com.franca.hrpayroll.dtos.WorkerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final IHrWorkerClient workerClient;

    public Payment getPayment(long workerId, int days) {
        log.info("obtendo um pagamento por worker id: {} com dias trabalhados: {}", workerId, days);

        WorkerDTO dto = workerClient.findById(workerId);
        return new Payment(dto.getName(), dto.getDailyIncome(), days);
    }
}
