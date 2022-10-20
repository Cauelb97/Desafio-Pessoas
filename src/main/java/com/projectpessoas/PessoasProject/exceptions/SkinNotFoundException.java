package com.projectpessoas.PessoasProject.exceptions;

import java.text.MessageFormat;

public class SkinNotFoundException extends RuntimeException{

	public SkinNotFoundException(Long id) {
		super(MessageFormat.format("Could not find skin with id: {0}", id));
	}
}
