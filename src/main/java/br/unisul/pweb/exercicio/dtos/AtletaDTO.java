package br.unisul.pweb.exercicio.dtos;

import java.io.Serializable;

import br.unisul.pweb.exercicio.domain.Atleta;

public class AtletaDTO implements Serializable  {
	private static final long serialVersionUID = 1L;	
	
	private Integer id;
	private String nome;
	private String modalidade;
	
	public AtletaDTO() {		
		
	}
	
	
	public AtletaDTO(Atleta a) {
		this.id = a.getId();
		this.nome = a.getNome();
		this.modalidade = a.getModalidade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

}
