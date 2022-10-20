package com.projectpessoas.PessoasProject.entity.dto;

import java.util.Objects;

import com.projectpessoas.PessoasProject.entity.HairColor;

public class HairRequestModel {

	
	private Long id;
	private ColorsRequestModels colorsReq;
	private PessoasRequestModel p;
	
	public HairRequestModel() {}

	public HairRequestModel(ColorsRequestModels colorsReq, PessoasRequestModel p) {
		this.colorsReq = colorsReq;
		this.p = p;
	}
	
	public static HairRequestModel from(HairColor hairColor) {
		HairRequestModel hairRequestModel =new HairRequestModel();
		if(Objects.nonNull(hairColor.getColors())){
			hairRequestModel.setColorsReq(ColorsRequestModels.from(hairColor.getColors()));
        }
		if(Objects.nonNull(hairColor.getPessoas())){
			hairRequestModel.setP(PessoasRequestModel.from(hairColor.getPessoas()));
        }
		return hairRequestModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ColorsRequestModels getColorsReq() {
		return colorsReq;
	}

	public void setColorsReq(ColorsRequestModels colorsReq) {
		this.colorsReq = colorsReq;
	}

	public PessoasRequestModel getP() {
		return p;
	}

	public void setP(PessoasRequestModel p) {
		this.p = p;
	}
	
	
}
