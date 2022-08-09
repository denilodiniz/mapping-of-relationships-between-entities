package br.com.ddev.mappingrelationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddev.mappingrelationships.entities.Pagamento;
import br.com.ddev.mappingrelationships.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {
	
	@Autowired
	private PagamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> findAll() {
		List<Pagamento> pagamentos = service.findAll();
		return ResponseEntity.ok().body(pagamentos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pagamento> findById(@PathVariable Long id) {
		Pagamento pagamento = service.findById(id);
		return ResponseEntity.ok().body(pagamento);
	}
	
	
}
