package com.projectpessoas.PessoasProject.entity.dto;

import java.sql.Date;
import java.util.List;

import com.projectpessoas.PessoasProject.entity.Films;
import com.projectpessoas.PessoasProject.entity.Pessoas;

public class FilmsRequestModel {

	private Integer episode_id;
	private String title;
	private String opening_crawl;	
	private String director;
	private String producer;
	private String release_date;
	private Date created;
	private Date edited;
	private List<Pessoas> person;
	
	public FilmsRequestModel() {}

	public FilmsRequestModel(Integer episode_id, String title, String opening_crawl, String director, String producer,
			String release_date, Date created, Date edited, List<Pessoas> person) {
		this.episode_id = episode_id;
		this.title = title;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.created = created;
		this.edited = edited;
		this.person = person;
	}

	public static FilmsRequestModel from(Films films) {
		FilmsRequestModel filmsRequestModel = new FilmsRequestModel();
		filmsRequestModel.setEpisode_id(films.getEpisode_id());
		filmsRequestModel.setTitle(films.getTitle());
		filmsRequestModel.setOpening_crawl(films.getOpening_crawl());
		filmsRequestModel.setDirector(films.getDirector());
		filmsRequestModel.setProducer(films.getProducer());
		filmsRequestModel.setRelease_date(films.getRelease_date());
		filmsRequestModel.setCreated(films.getCreated());
		filmsRequestModel.setEdited(films.getEdited());
		filmsRequestModel.setPerson(films.getPerson());
		return filmsRequestModel;
	}

	public Integer getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(Integer episode_id) {
		this.episode_id = episode_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getEdited() {
		return edited;
	}

	public void setEdited(Date edited) {
		this.edited = edited;
	}

	public List<Pessoas> getPerson() {
		return person;
	}

	public void setPerson(List<Pessoas> person) {
		this.person = person;
	}
}
