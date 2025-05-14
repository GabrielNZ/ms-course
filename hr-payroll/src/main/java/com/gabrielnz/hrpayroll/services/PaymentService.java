package com.gabrielnz.hrpayroll.services;

import com.gabrielnz.hrpayroll.entities.Payment;
import com.gabrielnz.hrpayroll.entities.Worker;
import com.gabrielnz.hrpayroll.feignclients.WorkerFeignCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private WorkerFeignCliente workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }

}
