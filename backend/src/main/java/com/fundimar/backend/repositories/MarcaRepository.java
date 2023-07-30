package com.fundimar.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundimar.backend.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {}
