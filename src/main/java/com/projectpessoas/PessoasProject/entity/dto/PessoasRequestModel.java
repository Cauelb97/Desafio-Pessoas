package com.projectpessoas.PessoasProject.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.entity.Films;
import com.projectpessoas.PessoasProject.entity.Gender;
import com.projectpessoas.PessoasProject.entity.HairColor;
import com.projectpessoas.PessoasProject.entity.Pessoas;
import com.projectpessoas.PessoasProject.entity.SkinColor;
import com.projectpessoas.PessoasProject.entity.Species;

public class PessoasRequestModel {

	private Long id;
	private String name;
	private Integer height;
	private Integer mass;
	private String birthyear;
	private Date created;
	private Date edited;
	private Gender gender;
	private Species species;
	private List<HairColor> hair_color = new ArrayList<>();
	private List<SkinColor> skin_color = new ArrayList<>();
	private List<EyeColor> eye_color = new ArrayList<>();
	private List<Films> films = new ArrayList<>();
	
	public PessoasRequestModel() {}

	public PessoasRequestModel(Long id, String name, Integer height, Integer mass, String birthyear, Date created,
			Date edited, Gender gender, Species species, List<HairColor> hair_color, List<SkinColor> skin_color,
			List<EyeColor> eye_color, List<Films> films) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.mass = mass;
		this.birthyear = birthyear;
		this.created = created;
		this.edited = edited;
		this.gender = gender;
		this.species = species;
		this.hair_color = hair_color;
		this.skin_color = skin_color;
		this.eye_color = eye_color;
		this.films = films;
	}

	public static PessoasRequestModel from(Pessoas pessoas) {
		PessoasRequestModel pessoasRequestModel = new PessoasRequestModel();
		pessoasRequestModel.setId(pessoas.getId());
		pessoasRequestModel.setName(pessoas.getName());
		pessoasRequestModel.setHeight(pessoas.getHeight());
		pessoasRequestModel.setMass(pessoas.getMass());
		pessoasRequestModel.setBirthyear(pessoas.getBirthyear());
		pessoasRequestModel.setCreated(pessoas.getCreated());
		pessoasRequestModel.setEdited(pessoas.getEdited());
		pessoasRequestModel.setGender(pessoas.getGender());
		pessoasRequestModel.setSpecies(pessoas.getSpecies());
		pessoasRequestModel.setHair_color(pessoas.getHairColor());
		pessoasRequestModel.setSkin_color(pessoas.getSkinColor());
		pessoasRequestModel.setEye_color(pessoas.getEyeColor());
		pessoasRequestModel.setFilms(pessoas.getFilms());
		return pessoasRequestModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMass() {
		return mass;
	}

	public void setMass(Integer mass) {
		this.mass = mass;
	}

	public String getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getEdited() {
		return edited;
	}

	public void setEdited(Date edited) {
		this.edited = edited;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public List<HairColor> getHair_color() {
		return hair_color;
	}

	public void setHair_color(List<HairColor> hair_color) {
		this.hair_color = hair_color;
	}

	public List<SkinColor> getSkin_color() {
		return skin_color;
	}

	public void setSkin_color(List<SkinColor> skin_color) {
		this.skin_color = skin_color;
	}

	public List<EyeColor> getEye_color() {
		return eye_color;
	}

	public void setEye_color(List<EyeColor> eye_color) {
		this.eye_color = eye_color;
	}

	public List<Films> getFilms() {
		return films;
	}

	public void setFilms(List<Films> films) {
		this.films = films;
	}
	
	
}
