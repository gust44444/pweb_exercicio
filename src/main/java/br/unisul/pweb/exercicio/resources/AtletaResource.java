package br.unisul.pweb.exercicio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.pweb.exercicio.domain.Atleta;
import br.unisul.pweb.exercicio.dtos.AtletaDTO;
import br.unisul.pweb.exercicio.resources.util.URL;
import br.unisul.pweb.exercicio.services.AtletaService;

@RestController
@RequestMapping(value="/atletas")
public class AtletaResource {
	
	@Autowired
	private AtletaService serv;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Atleta> find(@PathVariable Integer id) {
		Atleta obj = serv.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> find(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "competicoes", defaultValue = "") String competicoes) {

		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(competicoes);
		List<Atleta> list = serv.search(nomeDecoded, ids);
		List<AtletaDTO> listDto = new ArrayList<AtletaDTO>();
		for (Atleta a : list) {
			listDto.add(new AtletaDTO(a));
		}
		return ResponseEntity.ok().body(listDto);

	}
	
}
