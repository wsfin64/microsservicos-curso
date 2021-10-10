package com.wsfin64.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsfin64.hrworker.entities.Worker;



public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	

}
