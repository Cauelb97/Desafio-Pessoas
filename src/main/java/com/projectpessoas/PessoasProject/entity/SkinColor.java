package com.projectpessoas.PessoasProject.entity;

import java.io.Serializable;
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
import com.projectpessoas.PessoasProject.entity.dto.SkinRequestModel;

@Entity
@Table(name="skin_color")
public class SkinColor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idskin_color")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "color_idcolor")
	private Colors colors;
	
	
	@ManyToOne
	@JoinColumn(name = "people_id")
	private Pessoas skin_color;
	
	public SkinColor() {
		
	}

	public SkinColor(Integer id, Colors colors, Pessoas pessoas) {
		this.id = id;
		this.colors = colors;
		this.skin_color = pessoas;
	}
	
	public static SkinColor from(SkinRequestModel skin_color) {
		SkinColor skin = new SkinColor();
		return skin;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Colors getColors() {
		return colors;
	}


	public void setColors(Colors colors) {
		this.colors = colors;
	}


	public Pessoas getPessoas() {
		return skin_color;
	}


	public void setPessoas(Pessoas pessoas) {
		this.skin_color = pessoas;
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
		SkinColor other = (SkinColor) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
