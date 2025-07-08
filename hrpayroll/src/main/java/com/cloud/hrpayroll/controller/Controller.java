package com.cloud.hrpayroll.controller;

import com.cloud.hrpayroll.entities.Payment;
import com.cloud.hrpayroll.service.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class Controller {

    @Autowired
    private PaymentService service;

    @GetMapping("/{workerId}/days/{days}")
    @CircuitBreaker(name = "getPaymentAlternative", fallbackMethod = "fallbackMethod")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> fallbackMethod(Long workerId, Integer days, Throwable t) {
        System.out.println("Fallback Controller chamado");
        return ResponseEntity.ok(new Payment("Fallback Controller", 0.0, days));
    }

}
