package com.projectpessoas.PessoasProject.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.exceptions.EyeNotFoundException;
import com.projectpessoas.PessoasProject.repository.EyeRepository;

@Service
public class EyeService {

	private final EyeRepository eyeRepository;

	public EyeService(EyeRepository eyeRepository) {
		this.eyeRepository = eyeRepository;
	}


	public EyeColor getEye(Long id) {
		return  eyeRepository.findById(id).orElseThrow(() ->
			new EyeNotFoundException(id));
	}
	
	public EyeColor save(EyeColor eye) {
		return eyeRepository.save(eye);
	}
	
	public List<EyeColor> getEye(){
		 return StreamSupport
	                .stream(eyeRepository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	}

	
	public EyeColor deleteEye(Long id) {
		EyeColor eye = getEye(id);
		eyeRepository.delete(eye);
		return eye;
	}
	
	@Transactional
	public EyeColor editEye(Long id, EyeColor eyeColor){
		EyeColor eye = getEye(id);
		return eyeRepository.save(eye);
	}
}
