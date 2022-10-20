package com.projectpessoas.PessoasProject.exceptions;

import java.text.MessageFormat;

public class HairNotFoundException extends RuntimeException{
	
	public HairNotFoundException(Long id) {
		super(MessageFormat.format("Could not find hair with id: {0}", id));
	}
}
