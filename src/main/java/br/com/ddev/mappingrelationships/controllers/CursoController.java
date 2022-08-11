package br.com.ddev.mappingrelationships.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddev.mappingrelationships.entities.Curso;
import br.com.ddev.mappingrelationships.entities.Modulo;
import br.com.ddev.mappingrelationships.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> cursos=  service.findAll();
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id) {
		Curso curso = service.findById(id);
		return ResponseEntity.ok().body(curso);
	}
	
	@GetMapping("/{id}/modulos")
	public ResponseEntity<Set<Modulo>> findAllModulosByCursoId(@PathVariable Long id) {
		Set<Modulo> allModulosByCursoId = service.findById(id).getModulos();
		return ResponseEntity.ok().body(allModulosByCursoId);
	}
}
