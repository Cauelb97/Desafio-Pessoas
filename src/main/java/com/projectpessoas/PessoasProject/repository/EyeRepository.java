package com.projectpessoas.PessoasProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.projectpessoas.PessoasProject.entity.EyeColor;

public interface EyeRepository extends JpaRepository<EyeColor, Long>{

}
