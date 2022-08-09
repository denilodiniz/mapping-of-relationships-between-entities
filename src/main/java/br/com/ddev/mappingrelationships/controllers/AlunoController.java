package br.com.ddev.mappingrelationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddev.mappingrelationships.entities.Aluno;
import br.com.ddev.mappingrelationships.entities.Pagamento;
import br.com.ddev.mappingrelationships.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping(value = "/{id}/pagamentos")
	public ResponseEntity<List<Pagamento>> findAllPagamentos(@PathVariable Long id) {
		List<Pagamento> pagamentos = service.findById(id).getPagamentos();
		return ResponseEntity.ok().body(pagamentos);
	}
	
}
