package com.projectpessoas.PessoasProject.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projectpessoas.PessoasProject.entity.dto.EyeRequestModel;

@Entity
@Table(name="eye_color")
public class EyeColor {
	
	@Id
	@Column(name="ideye_color")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ideye_color;
	
	@ManyToOne
	@JoinColumn(name = "color_idcolor")
	private Colors color_idcolor;
	
	
	@ManyToOne
	@JoinColumn(name = "people_id")
	private Pessoas eye_color;
	
	public EyeColor() {
		
	}

	public EyeColor(Integer ideye_color, Colors color_idcolor, Pessoas people_id) {
		this.ideye_color = ideye_color;
		this.color_idcolor = color_idcolor;
		this.eye_color = people_id;
	}

	public static EyeColor from(EyeRequestModel eyeRequestModel) {
		EyeColor eye = new EyeColor();
		return eye;
	}
	
	public Integer getId() {
		return ideye_color;
	}


	public void setId(Integer ideye_color) {
		this.ideye_color = ideye_color;
	}


	public Colors getColors() {
		return color_idcolor;
	}


	public void setColors(Colors color_idcolor) {
		this.color_idcolor = color_idcolor;
	}


	public Pessoas getPessoas() {
		return eye_color;
	}


	public void setPessoas(Pessoas eye_color) {
		this.eye_color = eye_color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ideye_color);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EyeColor other = (EyeColor) obj;
		return ideye_color == other.ideye_color;
	}

	
}

