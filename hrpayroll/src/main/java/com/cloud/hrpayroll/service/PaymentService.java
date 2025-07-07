package com.cloud.hrpayroll.service;

import com.cloud.hrpayroll.client.WorkerFeignClient;
import com.cloud.hrpayroll.entities.Payment;
import com.cloud.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient client;

    public Payment getPayment(long workerId, Integer days) {
        Worker worker = client.findBId(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
