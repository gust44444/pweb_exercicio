package br.unisul.pweb.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.exercicio.domain.Competicao;

public interface CompeticaoRepository extends JpaRepository<Competicao, Integer> {

}
