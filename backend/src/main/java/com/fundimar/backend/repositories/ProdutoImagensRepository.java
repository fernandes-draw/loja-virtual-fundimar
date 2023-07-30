package com.fundimar.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundimar.backend.entities.ProdutoImagens;

public interface ProdutoImagensRepository
  extends JpaRepository<ProdutoImagens, Long> {}
