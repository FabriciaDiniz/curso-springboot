package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController //dispensa a anotação do RequestBody
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso != null) {
			
			//@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
			//List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
			
			List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
			//findByCursoNome||findByCurso_Nome é um padrão do Spring q já monta a query automaticamente
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		}
	}
}
