package com.wsfin64.hrpayroll.entities;

import java.io.Serializable;
import java.util.Objects;


public class WorkerResponse implements Serializable {
	 

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	private Double dailyIncome; 
	
	public WorkerResponse() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkerResponse other = (WorkerResponse) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
