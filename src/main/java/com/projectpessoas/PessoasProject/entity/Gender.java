package com.projectpessoas.PessoasProject.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gender")

public class Gender{
	
	@Id
	@Column(name="idgender")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="gender")
	private String gender;
	
	
	public Gender() {
		
	}

	public Gender(Integer id, String gender) {
		this.id = id;
		this.gender = gender;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, gender);
	}

}
