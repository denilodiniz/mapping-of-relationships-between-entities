package br.com.ddev.mappingrelationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.mappingrelationships.entities.Curso;
import br.com.ddev.mappingrelationships.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public Curso findById(Long id) {
		Optional<Curso> curso = repository.findById(id);
		return curso.get();
	}
	
	public List<Curso> findAll() {
		return repository.findAll();
	}
	
}
