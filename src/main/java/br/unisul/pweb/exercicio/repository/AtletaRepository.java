package br.unisul.pweb.exercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.exercicio.domain.Atleta;
import br.unisul.pweb.exercicio.domain.Competicao;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Integer>{
	
	List<Atleta> findDistinctByNomeContainingAndCompeticoesIn(
			String nome,
			List<Competicao> competicoes
	);
	
	
	
	

}
