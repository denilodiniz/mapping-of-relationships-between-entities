package br.com.ddev.mappingrelationships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddev.mappingrelationships.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
