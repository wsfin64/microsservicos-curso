package com.wsfin64.hrpayroll.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wsfin64.hrpayroll.entities.WorkerResponse;


@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<WorkerResponse> findWorkerById(@PathVariable("id") Long id);
	
	@GetMapping
	ResponseEntity<List<WorkerResponse>> listWorkers();
}
