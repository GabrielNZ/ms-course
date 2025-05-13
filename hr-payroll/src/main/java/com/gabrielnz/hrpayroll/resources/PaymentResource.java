package com.gabrielnz.hrpayroll.resources;

import com.gabrielnz.hrpayroll.entities.Payment;
import com.gabrielnz.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payment> findById(@PathVariable Long id, @PathVariable Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(id,days));
    }
}
