package com.sensorweb.apirest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sensorweb.apirest.domain.model.Ponto;
import com.sensorweb.apirest.helper.ExcelHelper;
import com.sensorweb.apirest.message.Message;
import com.sensorweb.apirest.service.PontoService;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/pontos")
public class ExcelController {

	@Autowired
	PontoService fileService;

	@PostMapping("/uploadPontos")
	public ResponseEntity<Message> uploadPontos(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (ExcelHelper.verificarXlsx(file)) {
			try {
				fileService.save(file);
				message = "Upload feito com sucesso:  " + file.getOriginalFilename();
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

	@GetMapping("/pontos")
	public ResponseEntity<List<Ponto>> listarTodos() {
		try {
			List<Ponto> pontos = fileService.listarTodos();
			if (pontos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pontos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/por-id-e-tempo")
	public Optional<Ponto> pontoPorIdETempo(Long pontoId, String ts) {
		return fileService.pontoPorIdETempo(pontoId, ts);
	}
}