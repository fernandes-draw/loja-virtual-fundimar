package com.fundimar.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundimar.backend.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
