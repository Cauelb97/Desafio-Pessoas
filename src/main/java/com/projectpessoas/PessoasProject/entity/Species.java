package com.projectpessoas.PessoasProject.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="species")
public class Species {

	
	@Id
	@Column(name="idspecies")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="species")
	private String species;
	
	public Species() {
		
	}

	public Species(Integer id, String species) {
		this.id = id;
		this.species = species;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, species);
	}
}
