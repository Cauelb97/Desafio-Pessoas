package com.projectpessoas.PessoasProject.entity.dto;

import com.projectpessoas.PessoasProject.entity.Species;

public class SpeciesRequestModel {

	private Integer id;
	private String species;
	
	public SpeciesRequestModel() {}

	public SpeciesRequestModel(Integer id, String species) {
		this.id = id;
		this.species = species;
	}
	
	public static SpeciesRequestModel from(Species species) {
		SpeciesRequestModel speciesRequestModel = new SpeciesRequestModel();
		speciesRequestModel.setId(species.getId());
		speciesRequestModel.setSpecies(species.getSpecies());
		return speciesRequestModel;
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

	
}
