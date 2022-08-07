package br.com.ddev.mappingrelationships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.mappingrelationships.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
