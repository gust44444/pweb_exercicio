package br.unisul.pweb.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.exercicio.domain.Competicao;
import br.unisul.pweb.exercicio.repository.CompeticaoRepository;

@Service
public class CompeticaoService {
	
	@Autowired // evita instanciar variáveis repetidamente
	private CompeticaoRepository rep;
	
	//BUSCAR POR ID 
	public Competicao find (Integer id) {
		Optional<Competicao> obj = rep.findById(id);
		return obj.orElse(null);
	}
		
	//INSERIR
	public Competicao insert (Competicao obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Competicao update (Competicao obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
		
	//LISTAR TODAS
	public List<Competicao> findAll(){
		return rep.findAll();
	}
}
