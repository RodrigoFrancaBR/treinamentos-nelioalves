package br.com.franca.hrpayroll.api.controller;

import br.com.franca.hrpayroll.domain.model.Payment;
import br.com.franca.hrpayroll.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payments")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @GetMapping(path = "/{workerId}/days/{days}")
    public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        log.info("obtendo um pagamento por worker id: {} com dias trabalhados: {}", workerId, days);
        return service.getPayment(workerId, days);
    }
}
