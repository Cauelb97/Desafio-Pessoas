package com.projectpessoas.PessoasProject.entity.dto;

import com.projectpessoas.PessoasProject.entity.Gender;

public class GenderRequestModel {

	private Integer id;
	private String gender;
	
	public GenderRequestModel() {}

	public GenderRequestModel(Integer id, String gender) {
		this.id = id;
		this.gender = gender;
	}

	public static GenderRequestModel from(Gender gender) {
		GenderRequestModel genderRequestModel = new GenderRequestModel();
		genderRequestModel.setId(gender.getId());
		genderRequestModel.setGender(gender.getGender());
		return genderRequestModel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
