package com.sensorweb.apirest.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "dado")
@Data
public class Dado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private double dado;
	
	@Column(columnDefinition = "datetime")
	private String ts;
	
	public Dado() {
		
	}

	public Dado(double dado, String ts) {
		this.dado = dado;
		this.ts = ts;
	}

	@Override
	public String toString() {
		return "Ponto [id=" + id + ", dado=" + dado + ", ts=" + ts + "]";
	}
}
