package com.projectpessoas.PessoasProject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="color")
public class Colors implements Serializable{
	
	private String serialNumber;
	@Id
	@Column(name="idcolor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="color")
	private String color;

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

	public Colors(Integer id, String color) { 
		this.id = id;
		this.color = color;

	}
	
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void addSkin(SkinColor skin) {
		skin_color.add(skin);
	}
	
	public void removeSkin(SkinColor skin) {
		skin_color.remove(skin);
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<HairColor> getHairColor() {
		return hair_color;
	}

	public void setHairColor(List<HairColor> hair_color) {
		this.hair_color = hair_color;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colors other = (Colors) obj;
		return Objects.equals(id, other.id);
	}
}
