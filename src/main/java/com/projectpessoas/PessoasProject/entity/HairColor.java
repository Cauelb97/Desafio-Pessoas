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
import com.projectpessoas.PessoasProject.entity.dto.HairRequestModel;

@Entity
@Table(name="hair_color")
public class HairColor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idhair_color")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "color_idcolor")
	private Colors colors;
	
	
	@ManyToOne
	@JoinColumn(name = "people_id")
	private Pessoas hair_color;
	
	public HairColor() {
		
	}

	public HairColor(Long id, Colors colors, Pessoas pessoas) {
		this.id = id;
		this.colors = colors;
		this.hair_color = pessoas;
	}
	
	public static HairColor from(HairRequestModel hair_color) {
		HairColor hair = new HairColor();
		return hair;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Colors getColors() {
		return colors;
	}


	public void setColors(Colors colors) {
		this.colors = colors;
	}


	public Pessoas getPessoas() {
		return hair_color;
	}


	public void setPessoas(Pessoas pessoas) {
		this.hair_color = pessoas;
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
		HairColor other = (HairColor) obj;
		return Objects.equals(id, other.id);
	}
}
