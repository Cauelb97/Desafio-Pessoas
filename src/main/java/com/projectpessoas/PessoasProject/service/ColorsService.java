package com.projectpessoas.PessoasProject.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projectpessoas.PessoasProject.entity.Colors;
import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.entity.HairColor;
import com.projectpessoas.PessoasProject.entity.SkinColor;
import com.projectpessoas.PessoasProject.exceptions.PessoasNotFoundException;
import com.projectpessoas.PessoasProject.repository.ColorsRepository;

@Service
public class ColorsService {

	final ColorsRepository colorsRepository;
	final EyeService eyeService;
	final SkinService skinService;
	final HairService hairService;
	
	
	public ColorsService(ColorsRepository colorsRepository, EyeService eyeService, SkinService skinService,
			HairService hairService) {
		this.colorsRepository = colorsRepository;
		this.eyeService = eyeService;
		this.skinService = skinService;
		this.hairService = hairService;
	}
	
	@Transactional 
	public Colors save (Colors pessoas) {		
		return colorsRepository.save(pessoas);
	}
	
	public List<Colors> getColors(){
        return StreamSupport
                .stream(colorsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
	
	public Colors getColors(Long id){
        return colorsRepository.findById(id).orElseThrow(() ->
                new PessoasNotFoundException(id));
    }
	
	@Transactional 
	public Colors editColors(Long id, Colors colors) {
		Colors colorsToEdit = getColors(id);
		colorsToEdit.setSerialNumber(colors.getSerialNumber());
		return colorsToEdit;
	}
	
	public Colors deleteColors(Long id) {
		Colors colors = getColors(id);
		colorsRepository.delete(colors);
		return colors;
	}
	
	@Transactional
	public Colors addHairToColors (Long hairId, Long colorId) {
		Colors color = getColors(colorId);
		HairColor hair = hairService.getHair(hairId);
		if (Objects.nonNull(hair.getColors())) {
			throw new RuntimeException(MessageFormat.format("HairColor ja existe", hairId, colorId));
		}
		color.addHair(hair);
		hair.setColors(color);
		return color;
	}
	
	@Transactional
	public Colors addSkinToColors (Long skinId, Long colorId) {
		Colors colors = getColors(colorId);
		SkinColor skin = skinService.getSkin(skinId);
		if (Objects.nonNull(skin.getColors())) {
			throw new RuntimeException(MessageFormat.format("SkinColor ja existe", skinId, colorId));
		}
		colors.addSkin(skin);
		skin.setColors(colors);
		return colors;
	}
	
	@Transactional
	public Colors addEyeToColors (Long eyeId, Long colorId) {
		Colors colors = getColors(colorId);
		EyeColor eye = eyeService.getEye(eyeId);
		if (Objects.nonNull(eye.getColors())) {
			throw new RuntimeException(MessageFormat.format("EyeColor ja existe", eyeId, colorId));
		}
		colors.addEye(eye);
		eye.setColors(colors);
		return colors;
	}
	
	@Transactional
	public Colors removeHairToColors (Long hairId, Long colorId) {
		Colors colors = getColors(colorId);
		HairColor hair = hairService.getHair(hairId);
		colors.removeHair(hair);
		return colors;
	}
	
	@Transactional
	public Colors removeSkinToColors (Long skinId, Long colorId) {
		Colors colors = getColors(colorId);
		SkinColor skin = skinService.getSkin(skinId);
		colors.removeSkin(skin);
		return colors;
	}
	
	@Transactional
	public Colors removeEyeToColors (Long eyeId, Long colorId) {
		Colors colors = getColors(colorId);
		EyeColor eye = eyeService.getEye(eyeId);
		colors.removeEye(eye);
		return colors;
	}
	
}
