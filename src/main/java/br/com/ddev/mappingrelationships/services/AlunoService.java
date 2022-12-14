package br.com.ddev.mappingrelationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.mappingrelationships.entities.Aluno;
import br.com.ddev.mappingrelationships.repositories.AlunoRepository;
import br.com.ddev.mappingrelationships.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public Aluno findById(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
}
