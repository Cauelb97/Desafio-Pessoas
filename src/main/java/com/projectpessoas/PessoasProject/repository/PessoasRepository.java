package com.projectpessoas.PessoasProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectpessoas.PessoasProject.entity.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
	Pessoas findById(long id);
	List<Pessoas> findAll();
}
