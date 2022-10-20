package com.projectpessoas.PessoasProject.exceptions;

import java.text.MessageFormat;

public class PessoasNotFoundException extends RuntimeException{
	
	public PessoasNotFoundException(Long id) {
		super(MessageFormat.format("Could not find pessoa with id: {0}", id));
	}

}
