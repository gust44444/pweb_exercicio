package br.unisul.pweb.exercicio.services;

import java.text.ParseException;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.exercicio.domain.Atleta;
import br.unisul.pweb.exercicio.domain.Competicao;
import br.unisul.pweb.exercicio.repository.AtletaRepository;
import br.unisul.pweb.exercicio.repository.CompeticaoRepository;


@Service
public class DbService {
	
	@Autowired
	CompeticaoRepository compRep;
	
	@Autowired
	AtletaRepository atletRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Competicao c1 = new Competicao(null, "Corrida - 100m rasos", "01/10/2019");
		Competicao c2 = new Competicao(null, "Salto em distância", "02/10/2019");
		Competicao c3 = new Competicao(null, "Salto com vara", "03/10/2019");
		Competicao c4 = new Competicao(null, "Salto em altura", "04/10/2019");
		Competicao c5 = new Competicao(null, "Corrida - 200m rasos", "05/10/2019");
		Competicao c6 = new Competicao(null, "Natação - 200m", "06/10/2019");
		Competicao c7 = new Competicao(null, "Natação - 400m", "07/10/2019");
		
		Atleta a1 = new Atleta(null,"Jailson", "Corrida");
		Atleta a2 = new Atleta(null,"José", "Natação");
		Atleta a3= new Atleta(null,"João", "Corrida");
		Atleta a4 = new Atleta(null,"Osvaldo", "Salto");
		
		c1.getAtletas().addAll(Arrays.asList(a1,a3));
		c2.getAtletas().addAll(Arrays.asList(a4));
		c3.getAtletas().addAll(Arrays.asList(a4));
		c4.getAtletas().addAll(Arrays.asList(a4));
		c5.getAtletas().addAll(Arrays.asList(a1));
		c6.getAtletas().addAll(Arrays.asList(a2));
		c7.getAtletas().addAll(Arrays.asList(a2));
		
		a1.getCompeticoes().addAll(Arrays.asList(c1,c5));
		a2.getCompeticoes().addAll(Arrays.asList(c6,c7));
		a3.getCompeticoes().addAll(Arrays.asList(c1));
		a4.getCompeticoes().addAll(Arrays.asList(c2,c3,c4));
		
		compRep.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		atletRep.saveAll(Arrays.asList(a1, a2, a3, a4));		
	}

}
