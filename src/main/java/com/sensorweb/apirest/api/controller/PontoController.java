/*
 * package com.sensorweb.apirest.api.controller;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.sensorweb.apirest.domain.model.PontoAntigo; import
 * com.sensorweb.apirest.domain.repository.PontoRepository;
 * 
 * @RestController
 * 
 * @RequestMapping("/pontos") public class PontoController {
 * 
 * @Autowired private PontoRepository pontoRepository;
 * 
 * @GetMapping("/por-id-e-tempo") public Optional<PontoAntigo>
 * pontoPorIdETempo(Long pontoId, String ts) { System.out.println(ts); return
 * pontoRepository.consultarPontoPorIdETempo(pontoId, ts); }
 * 
 * // fazer o notfound
 * 
 * @GetMapping("/{pontoId}") public List<PontoAntigo> pontoPorId(@PathVariable
 * Long pontoId) { return pontoRepository.consultarPorId(pontoId); }
 * 
 * @GetMapping public List<PontoAntigo> listar() { return
 * pontoRepository.findAll(); } }
 */