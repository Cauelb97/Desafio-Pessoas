package com.projectpessoas.PessoasProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectpessoas.PessoasProject.entity.Films;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Long> {
	Films findById(long id);
	List<Films> findAll();
}