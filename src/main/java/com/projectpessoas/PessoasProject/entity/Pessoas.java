package com.projectpessoas.PessoasProject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projectpessoas.PessoasProject.entity.dto.PessoasRequestModel;

@Entity
@Table(name="People")
public class Pessoas{
	

	private String serialNumber;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Integer height;
	
	private Integer mass;
	

	private String birthyear;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "GMT")
	private Date created;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "GMT")
	private Date edited;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="genderid")
	private Gender gender;
	
	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="speciesid")
	private Species species;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hair_color")
	@Cascade(CascadeType.ALL)
	private List<HairColor> hair_color = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "skin_color")
	@Cascade(CascadeType.ALL)
	private List<SkinColor> skin_color = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "eye_color")
	@Cascade(CascadeType.ALL)
	private List<EyeColor> eye_color = new ArrayList<>();
	
	@ManyToMany(mappedBy="person")
	@JsonManagedReference
	private List<Films> films = new ArrayList<>();
	
	public Pessoas() {
		
	}

	public Pessoas(Long id, String name, Integer height, Integer mass, String birthyear, Date created, Date edited, Gender gender, Species species) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.mass = mass;
		this.birthyear = birthyear;
		this.created = created;
		this.edited = edited;
		this.gender = gender;
		this.species = species;
	}


	public void addFilm(Films film) {
		films.add(film);
	}
	
	public void removeFilm(Films film) {
		films.remove(film);
	}
	
	public void addSkin(SkinColor skin) {
		skin_color.add(skin);
	}
	
	public void removeSkin(SkinColor skin) {
		skin_color.remove(skin);
	}
	
	public static Pessoas from(PessoasRequestModel pessoasRequestModel) {
		Pessoas pessoas = new Pessoas();
		pessoas.setName(pessoasRequestModel.getName());
		return pessoas;
	}
	
	public void addHair(HairColor hair) {
		hair_color.add(hair);
	}
	
	public void removeHair(HairColor hair) {
		hair_color.remove(hair);
	}
	
	public void addEye(EyeColor eye) {
		eye_color.add(eye);
	}
	
	public void removeEye(EyeColor eye) {
		eye_color.remove(eye);
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

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
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

	public List<HairColor> getHairColor() {
		return hair_color;
	}

	public void setHairColor(List<HairColor> hairColor) {
		this.hair_color = hairColor;
	}

	public List<SkinColor> getSkinColor() {
		return skin_color;
	}

	public void setSkinColor(List<SkinColor> skinColor) {
		this.skin_color = skinColor;
	}

	public List<EyeColor> getEyeColor() {
		return eye_color;
	}

	public void setEyeColor(List<EyeColor> eyeColor) {
		this.eye_color = eyeColor;
	}

	public List<Films> getFilms() {
		return films;
	}

	public void setFilms(List<Films> films) {
		this.films = films;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
