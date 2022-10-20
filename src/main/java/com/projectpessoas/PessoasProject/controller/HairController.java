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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpessoas.PessoasProject.entity.HairColor;
import com.projectpessoas.PessoasProject.entity.dto.HairRequestModel;
import com.projectpessoas.PessoasProject.service.HairService;

@RestController
@RequestMapping("/HairColor")
public class HairController {

	private final HairService hairService;

	@Autowired
	public HairController(HairService hairService) {
		this.hairService = hairService;
	}

	@GetMapping("/all")
	public List<HairColor> findAll(){
		return hairService.getHair();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<HairRequestModel> getHair(@PathVariable final Long id){
		HairColor hairColor = hairService.getHair(id);
		return new ResponseEntity<>(HairRequestModel.from(hairColor), HttpStatus.OK);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<HairRequestModel> inserirHair(@RequestBody final HairRequestModel hairRequestModel){
		HairColor hair = hairService.save(HairColor.from(hairRequestModel));
		return new ResponseEntity<>(HairRequestModel.from(hair), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<HairRequestModel> deleteHair(@PathVariable final Long id){
		HairColor hair = hairService.deleteHair(id);
		return new ResponseEntity<>(HairRequestModel.from(hair), HttpStatus.OK);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,value = "{id}")
	public ResponseEntity<HairRequestModel> editHair(@PathVariable final Long id,
													@RequestBody final HairRequestModel hairRequestModel){
		HairColor hair = hairService.editHair(id, HairColor.from(hairRequestModel));
		return new ResponseEntity<>(HairRequestModel.from(hair), HttpStatus.OK);
	}
	
	
}
