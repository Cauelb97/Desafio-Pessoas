package com.projectpessoas.PessoasProject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpessoas.PessoasProject.entity.Pessoas;
import com.projectpessoas.PessoasProject.entity.dto.PessoasRequestModel;
import com.projectpessoas.PessoasProject.service.PessoasService;

@RestController 
@RequestMapping(value="people") // http://localhost:8080/people
public class PessoasController {
	
	private final PessoasService pessoasService;
	
	@Autowired
	public PessoasController(PessoasService pessoasService) {
		this.pessoasService = pessoasService;
	}

	@GetMapping
	public ResponseEntity<List<PessoasRequestModel>> getPessoas(){
		List<Pessoas> pessoas = pessoasService.getPessoas();
		List<PessoasRequestModel> pessoasRequestModels = pessoas.stream().map(PessoasRequestModel::from).collect(Collectors.toList());
		return new ResponseEntity<>(pessoasRequestModels, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<PessoasRequestModel> getPessoa(@PathVariable final Long id ) {
		Pessoas pessoas = pessoasService.getPessoas(id);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<PessoasRequestModel> atualizarPessoa(@PathVariable final Long id, @RequestBody final PessoasRequestModel p) {
		Pessoas pessoas = pessoasService.editPessoas(id, Pessoas.from(p));
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@PostMapping(value ="/inserir")
	public ResponseEntity<PessoasRequestModel> inserirPessoas(@RequestBody final PessoasRequestModel p) {
		Pessoas pessoas = pessoasService.save(Pessoas.from(p));
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@PostMapping(value = "{pessoaId}/hair/{hairId}/add")
	public ResponseEntity<PessoasRequestModel> addHairToPessoas(@PathVariable("pessoaId") final Long pessoaId,
																@PathVariable("hairId") final Long hairId){
		Pessoas pessoas = pessoasService.addHairToPessoas(pessoaId, hairId);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@PostMapping(value = "{pessoaId}/skin/{skinId}/add")
	public ResponseEntity<PessoasRequestModel> addSkinToPessoas(@PathVariable("pessoaId") final Long pessoaId,
																@PathVariable("skinId") final Long skinId){
		Pessoas pessoas = pessoasService.addSkinToPessoas(pessoaId, skinId);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@PostMapping(value = "{pessoaId}/eye/{eyeId}/add")
	public ResponseEntity<PessoasRequestModel> addEyeToPessoas(@PathVariable("pessoaId") final Long pessoaId,
																@PathVariable("eyeId") final Long eyeId){
		Pessoas pessoas = pessoasService.addEyeToPessoas(pessoaId, eyeId);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{pessoaId}/hair/{hairId}/add")
	public ResponseEntity<PessoasRequestModel> removeHairToPessoas(@PathVariable("pessoaId") final Long pessoaId,
																@PathVariable("hairId") final Long hairId){
		Pessoas pessoas = pessoasService.removeHairToPessoas(pessoaId, hairId);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{pessoaId}/skin/{skinId}/add")
	public ResponseEntity<PessoasRequestModel> removeSkinToPessoas(@PathVariable("pessoaId") final Long pessoaId,
																@PathVariable("skinId") final Long skinId){
		Pessoas pessoas = pessoasService.removeSkinToPessoas(pessoaId, skinId);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{pessoaId}/eye/{eyeId}/add")
	public ResponseEntity<PessoasRequestModel> removeEyeToPessoas(@PathVariable("pessoaId") final Long pessoaId,
																@PathVariable("eyeId") final Long eyeId){
		Pessoas pessoas = pessoasService.removeEyeToPessoas(pessoaId, eyeId);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<PessoasRequestModel> deletePessoa(@PathVariable final Long id ) {
		Pessoas pessoas = pessoasService.deletePessoa(id);
		return new ResponseEntity<>(PessoasRequestModel.from(pessoas), HttpStatus.OK);
	}
}
