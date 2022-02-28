package com.wsfin64.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsfin64.hrworker.entities.Worker;
import com.wsfin64.hrworker.repositories.WorkerRepository;


@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findbyId(@PathVariable("id") Long id){
		
		// Forçando um timeout
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		return ResponseEntity.ok(repository.findById(id).get());
	}

}
