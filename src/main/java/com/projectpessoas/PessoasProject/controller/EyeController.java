package com.projectpessoas.PessoasProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.entity.dto.EyeRequestModel;
import com.projectpessoas.PessoasProject.service.EyeService;

public class EyeController {

	
	private final EyeService eyeService;

	@Autowired
	public EyeController(EyeService eyeService) {
		this.eyeService = eyeService;
	}

	@GetMapping("/all")
	public List<EyeColor> findAll(){
		return eyeService.getEye();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<EyeRequestModel> getEye(@PathVariable final Long id){
		EyeColor eyeColor = eyeService.getEye(id);
		return new ResponseEntity<>(EyeRequestModel.from(eyeColor), HttpStatus.OK);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<EyeRequestModel> inserirEyeColor(@RequestBody final EyeRequestModel eyeRequestModel){
		EyeColor eyeColor = eyeService.save(EyeColor.from(eyeRequestModel));
		return new ResponseEntity<>(EyeRequestModel.from(eyeColor), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<EyeRequestModel> deleteeyeColor(@PathVariable final Long id){
		EyeColor eyeColor = eyeService.deleteEye(id);
		return new ResponseEntity<>(EyeRequestModel.from(eyeColor), HttpStatus.OK);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,value = "{id}")
	public ResponseEntity<EyeRequestModel> editeyeColor(@PathVariable final Long id,
													@RequestBody final EyeRequestModel EyeRequestModel){
		EyeColor eyeColor = eyeService.editEye(id, EyeColor.from(EyeRequestModel));
		return new ResponseEntity<>(EyeRequestModel.from(eyeColor), HttpStatus.OK);
	}
}
