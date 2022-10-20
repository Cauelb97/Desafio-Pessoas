package com.projectpessoas.PessoasProject.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.projectpessoas.PessoasProject.entity.Colors;
import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.entity.HairColor;
import com.projectpessoas.PessoasProject.entity.SkinColor;

public class ColorsRequestModels {

	private Integer id;
	private String color;
	private List<HairColor> hair_color = new ArrayList<>();
	private List<SkinColor> skin_color = new ArrayList<>();
	private List<EyeColor> eye_color = new ArrayList<>();
	
	public ColorsRequestModels() {}

	public ColorsRequestModels(Integer id, String color, List<HairColor> hair_color, List<SkinColor> skin_color,
			List<EyeColor> eye_color) {
		super();
		this.id = id;
		this.color = color;
		this.hair_color = hair_color;
		this.skin_color = skin_color;
		this.eye_color = eye_color;
	}

	public static ColorsRequestModels from(Colors colors) {
		ColorsRequestModels colorsRequestModels = new ColorsRequestModels();
		colorsRequestModels.setId(colors.getId());
		colorsRequestModels.setColor(colors.getColor());
		colorsRequestModels.setHair_color(colors.getHairColor());
		colorsRequestModels.setSkin_color(colors.getSkinColor());
		colorsRequestModels.setEye_color(colors.getEyeColor());
		return colorsRequestModels;
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
}
