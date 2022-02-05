package com.wsfin64.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wsfin64.hrpayroll.entities.Payment;

import com.wsfin64.hrpayroll.entities.WorkerResponse;
import com.wsfin64.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerClient;
	
	public Payment getPayment(long workerId, int days) {
		
		// Eviando requisição para o endpont [GET] getWorker do serviço hr-worker 
		WorkerResponse worker = workerClient.findbyId(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
