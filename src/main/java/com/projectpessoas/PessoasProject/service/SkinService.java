package com.projectpessoas.PessoasProject.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projectpessoas.PessoasProject.entity.SkinColor;
import com.projectpessoas.PessoasProject.exceptions.SkinNotFoundException;
import com.projectpessoas.PessoasProject.repository.SkinRepository;

@Service
public class SkinService {

	private final SkinRepository skinRepository;

	public SkinService(SkinRepository skinRepository) {
		this.skinRepository = skinRepository;
	}

	
	public SkinColor save(SkinColor skin) {
		return skinRepository.save(skin);
	}
	
	public List<SkinColor> getSkins(){
		 return StreamSupport
	                .stream(skinRepository.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	}

	public SkinColor getSkin(Long id) {
		return  skinRepository.findById(id).orElseThrow(() ->
			new SkinNotFoundException(id));
	}
	
	public SkinColor deleteSkin(Long id) {
		SkinColor skin = getSkin(id);
		skinRepository.delete(skin);
		return skin;
	}
	
	@Transactional
	public SkinColor editSkin(Long id, SkinColor skinColor){
		SkinColor skin = getSkin(id);
		return skinRepository.save(skin);
	}
}
