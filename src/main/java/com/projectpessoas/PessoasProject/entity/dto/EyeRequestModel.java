package com.projectpessoas.PessoasProject.entity.dto;

import java.util.Objects;

import com.projectpessoas.PessoasProject.entity.EyeColor;
import com.projectpessoas.PessoasProject.entity.SkinColor;

public class EyeRequestModel {

	private Long id;
	private ColorsRequestModels colorsReq;
	private PessoasRequestModel p;
	
	public EyeRequestModel() {}

	public EyeRequestModel(ColorsRequestModels colorsReq, PessoasRequestModel p) {
		this.colorsReq = colorsReq;
		this.p = p;
	}
	
	public static EyeRequestModel from(EyeColor eyeColor) {
		EyeRequestModel eyeRequestModel = new EyeRequestModel();
		if(Objects.nonNull(eyeColor.getColors())){
			eyeRequestModel.setColorsReq(ColorsRequestModels.from(eyeColor.getColors()));
        }
		if(Objects.nonNull(eyeColor.getPessoas())){
			eyeRequestModel.setP(PessoasRequestModel.from(eyeColor.getPessoas()));
        }
		return eyeRequestModel;
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
