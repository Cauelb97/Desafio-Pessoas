package com.projectpessoas.PessoasProject.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpessoas.PessoasProject.entity.Films;
import com.projectpessoas.PessoasProject.exceptions.FilmNotFoundException;
import com.projectpessoas.PessoasProject.repository.FilmsRepository;

@Service
public class FilmsService {

	final FilmsRepository filmsRepository;

	@Autowired
	public FilmsService(FilmsRepository filmsRepository) {
		this.filmsRepository = filmsRepository;
	}
	
	@Transactional
	public Films save(Films films) {
		return filmsRepository.save(films);
	}
	
	public List<Films> getAll(){
		return StreamSupport
				.stream(filmsRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Films getFilms(Long id) {
		return filmsRepository.findById(id).orElseThrow(() ->
		new FilmNotFoundException(id));
		
	}
	
	@Transactional
	public Films editFilms(Long id, Films films) {
		Films filmsEdited = getFilms(id);
		filmsEdited.setSerialNumber(films.getSerialNumber());
		return filmsEdited;
	}
	
	public Films deleteFilm(Long id) {
		Films films = getFilms(id);
		filmsRepository.delete(films);
		return films;
	}
}
