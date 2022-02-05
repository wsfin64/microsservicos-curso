package com.wsfin64.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wsfin64.hrpayroll.entities.Payment;

import com.wsfin64.hrpayroll.entities.WorkerRequest;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		
		// Mapa de variaveis
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		// Eviando requisição para o endpont [GET] getWorker do serviço hr-worker 
		WorkerRequest worker = restTemplate.getForObject(workerHost + "/workers/{id}", WorkerRequest.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
