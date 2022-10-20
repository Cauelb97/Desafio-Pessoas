package com.projectpessoas.PessoasProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.xdevapi.PreparableStatement.PreparableStatementFinalizer;
import com.projectpessoas.PessoasProject.entity.Films;
import com.projectpessoas.PessoasProject.repository.FilmsRepository;

public class FilmsController {

	private final FilmsRepository filmsRepository;
	
	@Autowired
	public FilmsController(FilmsRepository filmsRepository) {
		super();
		this.filmsRepository = filmsRepository;
	}

	@GetMapping("/all")
	public List<Films> findAll(){
		return filmsRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Films getPessoa(@PathVariable (value = "id") long id ) {
		return (Films) filmsRepository.findById(id);
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,value ="/inserir")
	public @ResponseBody Films inserirPessoas(@RequestBody Films p) {
		return filmsRepository.save(p);
	}
	
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value="/deletar")
	public void deletarTaxa(@RequestBody Films p) {
		filmsRepository.delete(p);
	}
	 
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value="/atualizar")
	public Films atualizarTaxa(@RequestBody Films p) {
		return filmsRepository.save(p);
	}
}
