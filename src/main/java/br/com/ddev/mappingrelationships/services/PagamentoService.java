package br.com.ddev.mappingrelationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddev.mappingrelationships.entities.Pagamento;
import br.com.ddev.mappingrelationships.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repository;
	
	public List<Pagamento> findAll() {
		return repository.findAll();
	}
	
	public Pagamento findById(Long id) {
		Optional<Pagamento> pagamento = repository.findById(id);
		return pagamento.get();
	}
	
}
