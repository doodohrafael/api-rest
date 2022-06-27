package com.sensorweb.apirest.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sensorweb.apirest.domain.model.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long> {

	@Query("select p from Ponto p JOIN FETCH p.dados d where p.id = :id and d.ts = :ts")
	Optional<Ponto> consultarPontoPorIdETempo(Long id, String ts);
}
