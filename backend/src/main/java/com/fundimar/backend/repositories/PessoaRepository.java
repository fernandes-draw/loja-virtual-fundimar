package com.fundimar.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundimar.backend.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
