package com.cloud.payroll.service;

import com.cloud.payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, Integer days) {
        return new Payment("Bob", 200.00, days);
    }

}
