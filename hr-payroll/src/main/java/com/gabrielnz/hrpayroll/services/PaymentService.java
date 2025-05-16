package com.gabrielnz.hrpayroll.services;

import com.gabrielnz.hrpayroll.entities.Payment;
import com.gabrielnz.hrpayroll.entities.Worker;
import com.gabrielnz.hrpayroll.feignclients.WorkerFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private WorkerFeignClient workerFeignClient;

    @CircuitBreaker(name = "getpayment", fallbackMethod = "getPaymentFallback")
    public ResponseEntity<Payment> getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return ResponseEntity.ok(new Payment(worker.getName(), worker.getDailyIncome(), days));
    }

    public ResponseEntity<Payment> getPaymentFallback(Long workerId, int days, Throwable ex) {
        return ResponseEntity.ok(new Payment("Error",0.0, days));
    }
}
