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

import com.projectpessoas.PessoasProject.entity.SkinColor;
import com.projectpessoas.PessoasProject.entity.dto.SkinRequestModel;
import com.projectpessoas.PessoasProject.service.SkinService;

public class SkinController {

	private final SkinService skinService;

	@Autowired
	public SkinController(SkinService skinService) {
		this.skinService = skinService;
	}

	@GetMapping("/all")
	public List<SkinColor> findAll(){
		return skinService.getSkins();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<SkinRequestModel> getSkin(@PathVariable final Long id){
		SkinColor skinColor = skinService.getSkin(id);
		return new ResponseEntity<>(SkinRequestModel.from(skinColor), HttpStatus.OK);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<SkinRequestModel> inserirSkin(@RequestBody final SkinRequestModel SkinRequestModel){
		SkinColor skin = skinService.save(SkinColor.from(SkinRequestModel));
		return new ResponseEntity<>(SkinRequestModel.from(skin), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<SkinRequestModel> deleteSkin(@PathVariable final Long id){
		SkinColor hair = skinService.deleteSkin(id);
		return new ResponseEntity<>(SkinRequestModel.from(hair), HttpStatus.OK);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,value = "{id}")
	public ResponseEntity<SkinRequestModel> editSkin(@PathVariable final Long id,
													@RequestBody final SkinRequestModel SkinRequestModel){
		SkinColor skin = skinService.editSkin(id, SkinColor.from(SkinRequestModel));
		return new ResponseEntity<>(SkinRequestModel.from(skin), HttpStatus.OK);
	}
}
