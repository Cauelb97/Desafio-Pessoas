package com.projectpessoas.PessoasProject.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "films")
public class Films implements Serializable{
	private String serialNumber;
	
	@Id
	@Column(name = "episode_id") 
	private Integer episode_id;
	
	@Column(name = "title") 
	private String title;
	
	@Column(name = "opening_crawl") 
	private String opening_crawl;	
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "producer")
	private String producer;
	
	@Column(name = "release_date")
	private String release_date;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
	@Column(name = "created")
	private Date created;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
	@Column(name = "edited")
	private Date edited;
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "people_films",
			joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "episode_id"),
			inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id")
			)
	private List<Pessoas> person;
	
	
	public Films() {
	}

	public Films(Integer episode_id, String title, String opening_crawl, String director, String producer,
			String release_date, List<Pessoas> person) {
		this.episode_id = episode_id;
		this.title = title;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.person = person;
	} 

	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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

	public List<Pessoas> getPerson() {
		return person;
	}

	public void setPerson(List<Pessoas> person) {
		this.person = person;
	}

	public Date getCreated() {
		return created;
	}

	public Date getEdited() {
		return edited;
	}
	
}
