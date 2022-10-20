package com.projectpessoas.PessoasProject.exceptions;

import java.text.MessageFormat;

public class FilmNotFoundException extends RuntimeException{

	public FilmNotFoundException(Long id) {
		super(MessageFormat.format("Could not find film with id: {0}", id));
	}
}
