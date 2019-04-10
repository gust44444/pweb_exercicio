package br.unisul.pweb.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.exercicio.domain.Atleta;
import br.unisul.pweb.exercicio.domain.Competicao;
import br.unisul.pweb.exercicio.repository.AtletaRepository;
import br.unisul.pweb.exercicio.repository.CompeticaoRepository;

@Service
public class AtletaService {
	
	@Autowired 
	private AtletaRepository rep;
	
	@Autowired
	private CompeticaoRepository competicaoRepository;
	
	public Atleta find(Integer id) {
		Optional<Atleta> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public List<Atleta> search(String nome, List<Integer> ids) {
		List<Competicao> competicoes = competicaoRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndCompeticoesIn(nome, competicoes);
	}
	


}
