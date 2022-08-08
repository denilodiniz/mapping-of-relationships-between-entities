package br.com.ddev.mappingrelationships.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.ddev.mappingrelationships.entities.Aluno;
import br.com.ddev.mappingrelationships.entities.Aula;
import br.com.ddev.mappingrelationships.entities.Curso;
import br.com.ddev.mappingrelationships.entities.Modulo;
import br.com.ddev.mappingrelationships.entities.Pagamento;
import br.com.ddev.mappingrelationships.repositories.AlunoRepository;
import br.com.ddev.mappingrelationships.repositories.AulaRepository;
import br.com.ddev.mappingrelationships.repositories.CursoRepository;
import br.com.ddev.mappingrelationships.repositories.ModuloRepository;
import br.com.ddev.mappingrelationships.repositories.PagamentoRepository;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	ModuloRepository moduloRepository;
	
	@Autowired
	AulaRepository aulaRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Aluno aluno1 = new Aluno(null, "Denilo");
		Aluno aluno2 = new Aluno(null, "Priscyla");
		Aluno aluno3 = new Aluno(null, "Gustavo");
		
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
		Curso curso1 = new Curso(null, "Computação");
		Curso curso2 = new Curso(null, "Administração");
		Curso curso3 = new Curso(null, "Matemática");
		
		cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3));
		
		curso1.getAlunos().add(aluno1);
		curso2.getAlunos().add(aluno2);
		curso3.getAlunos().addAll(Arrays.asList(aluno1, aluno3));
		
		cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3));
		
		Modulo modulo1 = new Modulo(null, "Estrutura de Dados", curso1);
			Aula aula1 = new Aula(null, "Introdução a Estrutura de Dados", modulo1);
			Aula aula2 = new Aula(null, "Estrutura de Dados Pilha", modulo1);
			Aula aula3 = new Aula(null, "Estrutura de Dados Fila", modulo1);
		
		Modulo modulo2 = new Modulo(null, "Algoritmos", curso1);
			Aula aula4 = new Aula(null, "Introdução a Algoritmos", modulo2);
			Aula aula5 = new Aula(null, "Estruturas Condicionais", modulo2);
			Aula aula6 = new Aula(null, "Estruturas de Repetição", modulo2);
		
		Modulo modulo3 = new Modulo(null, "Contabilidade", curso2);
			Aula aula7 = new Aula(null, "Introdução a Contabilidade", modulo3);
			Aula aula8 = new Aula(null, "Patrimônio Líquido", modulo3);
			Aula aula9 = new Aula(null, "Custos e Despesas", modulo3);
		
		Modulo modulo4 = new Modulo(null, "Estatística", curso2);
			Aula aula10 = new Aula(null, "Introdução a Estatística", modulo4);
			Aula aula11 = new Aula(null, "Estatística Descritiva", modulo4);
			Aula aula12 = new Aula(null, "Estatística Inferencial", modulo4);
			
		Modulo modulo5 = new Modulo(null, "Cálculo 1", curso3);
			Aula aula13 = new Aula(null, "Números Reais", modulo5);
			Aula aula14 = new Aula(null, "Funções", modulo5);
			Aula aula15 = new Aula(null, "Derivada", modulo5);
			
		Modulo modulo6 = new Modulo(null, "Cálculo 2", curso3);
			Aula aula16 = new Aula(null, "Derivadas Parciais", modulo6);
			Aula aula17 = new Aula(null, "Derivada Direcional", modulo6);
			Aula aula18 = new Aula(null, "Integrais Duplas", modulo6);
		
		moduloRepository.saveAll(Arrays.asList(modulo1, modulo2, modulo3, modulo4, modulo5, modulo6));
		aulaRepository.saveAll(Arrays.asList(aula1, aula2, aula3, aula4, aula5, aula6, aula7, aula8, aula9, aula10, aula11, aula12, aula13, aula14, aula15, aula16, aula17, aula18));
		
		Pagamento pagamento1 = new Pagamento(null, BigDecimal.valueOf(549.99), Instant.parse("2019-06-20T19:53:07Z"), aluno1);
		Pagamento pagamento2 = new Pagamento(null, BigDecimal.valueOf(549.99), Instant.parse("2019-07-20T20:16:37Z"), aluno1);
		Pagamento pagamento3 = new Pagamento(null, BigDecimal.valueOf(549.99), Instant.parse("2019-08-20T19:30:51Z"), aluno1);
		
		Pagamento pagamento4 = new Pagamento(null, BigDecimal.valueOf(449.99), Instant.parse("2019-06-20T19:53:07Z"), aluno2);
		Pagamento pagamento5 = new Pagamento(null, BigDecimal.valueOf(449.99), Instant.parse("2019-07-20T20:16:37Z"), aluno2);
		Pagamento pagamento6 = new Pagamento(null, BigDecimal.valueOf(449.99), Instant.parse("2019-08-20T19:30:51Z"), aluno2);
		
		Pagamento pagamento7 = new Pagamento(null, BigDecimal.valueOf(249.99), Instant.parse("2019-06-20T19:53:07Z"), aluno3);
		Pagamento pagamento8 = new Pagamento(null, BigDecimal.valueOf(249.99), Instant.parse("2019-07-20T20:16:37Z"), aluno3);
		Pagamento pagamento9 = new Pagamento(null, BigDecimal.valueOf(249.99), Instant.parse("2019-08-20T19:30:51Z"), aluno3);
		
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2, pagamento3, pagamento4, pagamento5, pagamento6, pagamento7, pagamento8, pagamento9));
		
		
		
	}

	
	
}
