package br.com.ddev.mappingrelationships.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.ddev.mappingrelationships.entities.Aluno;
import br.com.ddev.mappingrelationships.entities.Curso;
import br.com.ddev.mappingrelationships.entities.Modulo;
import br.com.ddev.mappingrelationships.repositories.AlunoRepository;
import br.com.ddev.mappingrelationships.repositories.CursoRepository;
import br.com.ddev.mappingrelationships.repositories.ModuloRepository;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	ModuloRepository moduloRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Aluno aluno1 = new Aluno(null, "Denilo");
		Aluno aluno2 = new Aluno(null, "Priscyla");
		
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
		
		Curso curso1 = new Curso(null, "Computação");
		Curso curso2 = new Curso(null, "Administração");
		
		cursoRepository.saveAll(Arrays.asList(curso1, curso2));
		
		Modulo modulo1 = new Modulo(null, "Estrutura de Dados");
		Modulo modulo2 = new Modulo(null, "Algoritmos");
		Modulo modulo3 = new Modulo(null, "Contabilidade");
		Modulo modulo4 = new Modulo(null, "Estatística");
		
		modulo1.setCurso(curso1);
		modulo2.setCurso(curso1);
		modulo3.setCurso(curso2);
		modulo4.setCurso(curso2);
		
		moduloRepository.saveAll(Arrays.asList(modulo1, modulo2, modulo3, modulo4));
		
		
	}

	
	
}
