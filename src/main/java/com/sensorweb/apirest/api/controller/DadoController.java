package com.sensorweb.apirest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sensorweb.apirest.domain.model.Dado;
import com.sensorweb.apirest.domain.repository.DadoRepository;
import com.sensorweb.apirest.helper.ExcelHelper;
import com.sensorweb.apirest.message.Message;
import com.sensorweb.apirest.service.DadoService;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/dados")
public class DadoController {

	@Autowired
	DadoService dadoService;

	@Autowired
	DadoRepository dadoRepository;

	@PostMapping("/uploadDados")
	public ResponseEntity<Message> uploadDados(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (ExcelHelper.verificarXlsx(file)) {
			try {
				dadoService.save(file);
				message = "Upload feito com sucesso: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new Message(message));
			} catch (Exception e) {
				message = "Não foi possível fazer upload do arquivo: " + file.getOriginalFilename() + "!";
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Message(message));
			}
		}
		message = "Faça o upload de um arquivo excel (xlsx)!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message(message));
	}

	@GetMapping("/dados")
	public ResponseEntity<List<Dado>> listarTodos() {
		try {
			List<Dado> dados = dadoService.listarTodos();
			if (dados.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dados, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
