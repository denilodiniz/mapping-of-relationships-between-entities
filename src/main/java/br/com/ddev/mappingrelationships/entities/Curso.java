package br.com.ddev.mappingrelationships.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "curso")
	private Set<Modulo> modulos = new HashSet<>();
	
	@OneToMany(mappedBy = "curso")
	private Set<Matricula> matriculas = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "curso_aluno", 
		joinColumns = @JoinColumn(name = "id_curso"), 
		inverseJoinColumns = @JoinColumn(name = "id_aluno"))
	private Set<Aluno> alunos = new HashSet<>();
	//Exemplo a Udemy, que um aluno pode esta matriculado em diversos cursos
	
	public Curso() {
	}

	public Curso(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Modulo> getModulos() {
		return modulos;
	}

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

}
