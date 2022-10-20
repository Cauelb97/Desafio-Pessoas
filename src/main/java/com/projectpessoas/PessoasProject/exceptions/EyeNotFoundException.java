package com.projectpessoas.PessoasProject.exceptions;

import java.text.MessageFormat;

public class EyeNotFoundException extends RuntimeException{

	public EyeNotFoundException(Long id) {
		super(MessageFormat.format("Could not find eye with id: {0}", id));
	}
}
