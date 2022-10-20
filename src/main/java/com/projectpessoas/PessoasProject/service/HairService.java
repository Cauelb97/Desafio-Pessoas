package com.projectpessoas.PessoasProject.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projectpessoas.PessoasProject.entity.HairColor;
import com.projectpessoas.PessoasProject.exceptions.HairNotFoundException;
import com.projectpessoas.PessoasProject.repository.HairRepository;

@Service
public class HairService {
	
	private final HairRepository hairRepository;

	public HairService(HairRepository hairRepository) {
		this.hairRepository = hairRepository;
	}



	public HairColor getHair(Long id) {
		return  hairRepository.findById(id).orElseThrow(() ->
			new HairNotFoundException(id));
	}
	
	public HairColor save(HairColor hair) {
		return hairRepository.save(hair);
	}
	
	public List<HairColor> getHair(){
		 return StreamSupport
	                .stream(hairRepository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	}

	
	public HairColor deleteHair(Long id) {
		HairColor hair = getHair(id);
		hairRepository.delete(hair);
		return hair;
	}
	
	@Transactional
	public HairColor editHair(Long id, HairColor hairColor){
		HairColor hair = getHair(id);
		return hairRepository.save(hair);
	}
}
