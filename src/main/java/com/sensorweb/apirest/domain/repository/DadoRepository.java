package com.sensorweb.apirest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sensorweb.apirest.domain.model.Dado;

public interface DadoRepository extends JpaRepository<Dado, Long>{
	
}
