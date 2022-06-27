package com.sensorweb.apirest.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sensorweb.apirest.domain.model.Ponto;
import com.sensorweb.apirest.domain.repository.PontoRepository;
import com.sensorweb.apirest.helper.ExcelHelper;

@Service
public class PontoService {

	private static final String FALHA_AO_ARMAZENAR_DADOS_EXCEL = "Falha ao armazanar dados excel. ";

	@Autowired
	PontoRepository pontoRepository;

	public void save(MultipartFile file) {
		try {
			List<Ponto> pontos = ExcelHelper.importarDadosXlsx(file.getInputStream());
			pontoRepository.saveAll(pontos);
		} catch (IOException e) {
			throw new RuntimeException(FALHA_AO_ARMAZENAR_DADOS_EXCEL + e.getMessage());
		}
	}

	public List<Ponto> listarTodos() {
		return pontoRepository.findAll();
	}

	public Optional<Ponto> pontoPorIdETempo(Long pontoId, String ts) {
		try {
			Optional<Ponto> ponto = pontoRepository.consultarPontoPorIdETempo(pontoId, ts);
			return ponto;
		} catch (Exception e) {
			throw new RuntimeException(FALHA_AO_ARMAZENAR_DADOS_EXCEL + e.getMessage());
		}
	}
}