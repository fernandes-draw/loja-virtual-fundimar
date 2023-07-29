package com.fundimar.backend.repositories;

import com.fundimar.backend.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {}
