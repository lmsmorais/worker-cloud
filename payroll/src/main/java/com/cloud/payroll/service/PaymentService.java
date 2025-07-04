package com.cloud.payroll.service;

import com.cloud.payroll.client.WorkerFeignClient;
import com.cloud.payroll.entities.Payment;
import com.cloud.payroll.entities.Worker;
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
