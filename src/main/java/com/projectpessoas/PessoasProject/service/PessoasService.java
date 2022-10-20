package com.projectpessoas.PessoasProject.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.entity.HairColor;
import com.projectpessoas.PessoasProject.entity.Pessoas;
import com.projectpessoas.PessoasProject.entity.SkinColor;
import com.projectpessoas.PessoasProject.exceptions.PessoasNotFoundException;
import com.projectpessoas.PessoasProject.repository.PessoasRepository;

@Service
public class PessoasService {
	
	
	final PessoasRepository pessoasRepository;
	final EyeService eyeService;
	final SkinService skinService;
	final HairService hairService;
	final FilmsService filmsService;
	
	@Autowired
	public PessoasService(PessoasRepository pessoasRepository, EyeService eyeService, SkinService skinService,
			HairService hairService, FilmsService filmsService) {
		this.pessoasRepository = pessoasRepository;
		this.eyeService = eyeService;
		this.skinService = skinService;
		this.hairService = hairService;
		this.filmsService =filmsService;
	}
	
	@Transactional 
	public Pessoas save (Pessoas pessoas) {		
		return pessoasRepository.save(pessoas);
	}
	
	public List<Pessoas> getPessoas(){
        return StreamSupport
                .stream(pessoasRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
	
	public Pessoas getPessoas(Long id){
        return pessoasRepository.findById(id).orElseThrow(() ->
                new PessoasNotFoundException(id));
    }
	
	@Transactional 
	public Pessoas editPessoas(Long id, Pessoas pessoas) {
		Pessoas pessoaToEdit = getPessoas(id);
		pessoaToEdit.setSerialNumber(pessoas.getSerialNumber());
		return pessoaToEdit;
	}
	
	public Pessoas deletePessoa(Long id) {
		Pessoas pessoas = getPessoas(id);
		pessoasRepository.delete(pessoas);
		return pessoas;
	}
	
	@Transactional
	public Pessoas addHairToPessoas (Long hairId, Long pessoaId) {
		Pessoas pessoas = getPessoas(pessoaId);
		HairColor hair = hairService.getHair(hairId);
		if (Objects.nonNull(hair.getPessoas())) {
			throw new RuntimeException(MessageFormat.format("HairColor ja existe", hairId, pessoaId));
		}
		pessoas.addHair(hair);
		hair.setPessoas(pessoas);
		return pessoas;
	}
	
	@Transactional
	public Pessoas addSkinToPessoas (Long skinId, Long pessoaId) {
		Pessoas pessoas = getPessoas(pessoaId);
		SkinColor skin = skinService.getSkin(skinId);
		if (Objects.nonNull(skin.getPessoas())) {
			throw new RuntimeException(MessageFormat.format("SkinColor ja existe", skinId, pessoaId));
		}
		pessoas.addSkin(skin);
		skin.setPessoas(pessoas);
		return pessoas;
	}
	
	@Transactional
	public Pessoas addEyeToPessoas (Long eyeId, Long pessoaId) {
		Pessoas pessoas = getPessoas(pessoaId);
		EyeColor eye = eyeService.getEye(eyeId);
		if (Objects.nonNull(eye.getPessoas())) {
			throw new RuntimeException(MessageFormat.format("EyeColor ja existe", eyeId, pessoaId));
		}
		pessoas.addEye(eye);
		eye.setPessoas(pessoas);
		return pessoas;
	}
	
//	@Transactional
//	public Pessoas addFilmToPessoas (Long pessoaId, Long filmId) {
//		Pessoas pessoas = getPessoas(pessoaId);
//		Films films = filmsService.getFilms(filmId);
//		if (Objects.nonNull(films.getPerson())) {
//			throw new RuntimeException(MessageFormat.format("Film ja existe", filmId, pessoaId));
//		}
//		pessoas.addFilm(films);
//		films.setPerson(pessoas);
//		return pessoas;
//	}
	
	@Transactional
	public Pessoas removeHairToPessoas (Long hairId, Long pessoaId) {
		Pessoas pessoas = getPessoas(pessoaId);
		HairColor hair = hairService.getHair(hairId);
		pessoas.removeHair(hair);
		return pessoas;
	}
	
	@Transactional
	public Pessoas removeSkinToPessoas (Long skinId, Long pessoaId) {
		Pessoas pessoas = getPessoas(pessoaId);
		SkinColor skin = skinService.getSkin(skinId);
		pessoas.removeSkin(skin);
		return pessoas;
	}
	
	@Transactional
	public Pessoas removeEyeToPessoas (Long eyeId, Long pessoaId) {
		Pessoas pessoas = getPessoas(pessoaId);
		EyeColor eye = eyeService.getEye(eyeId);
		pessoas.removeEye(eye);
		return pessoas;
	}
}
