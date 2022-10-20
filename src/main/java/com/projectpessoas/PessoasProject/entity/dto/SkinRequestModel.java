package com.projectpessoas.PessoasProject.entity.dto;

import java.util.Objects;

import com.projectpessoas.PessoasProject.entity.SkinColor;

public class SkinRequestModel {

	private Long id;
	private ColorsRequestModels colorsReq;
	private PessoasRequestModel p;
	
	public SkinRequestModel() {}

	public SkinRequestModel(ColorsRequestModels colorsReq, PessoasRequestModel p) {
		this.colorsReq = colorsReq;
		this.p = p;
	}
	
	public static SkinRequestModel from(SkinColor skinColor) {
		SkinRequestModel skinRequestModel =new SkinRequestModel();
		if(Objects.nonNull(skinColor.getColors())){
			skinRequestModel.setColorsReq(ColorsRequestModels.from(skinColor.getColors()));
        }
		if(Objects.nonNull(skinColor.getPessoas())){
			skinRequestModel.setP(PessoasRequestModel.from(skinColor.getPessoas()));
        }
		return skinRequestModel;
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
