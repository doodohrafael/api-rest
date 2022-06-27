package com.sensorweb.apirest.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sensorweb.apirest.domain.model.Dado;
import com.sensorweb.apirest.domain.repository.DadoRepository;
import com.sensorweb.apirest.helper.DadoHelper;

@Service
public class DadoService {
	
	private static final String FALHA_AO_ARMAZENAR_DADOS_EXCEL = "Falha ao armazanar dados excel. ";

	@Autowired
	DadoRepository dadoRepository;

	public void save(MultipartFile file) {
		try {
			List<Dado> dados = DadoHelper.importarDadosXlsx(file.getInputStream());
			dadoRepository.saveAll(dados);
		} catch (IOException e) {
			throw new RuntimeException(FALHA_AO_ARMAZENAR_DADOS_EXCEL + e.getMessage());
		}
	}

	public List<Dado> listarTodos() {
		return dadoRepository.findAll();
	}

}
