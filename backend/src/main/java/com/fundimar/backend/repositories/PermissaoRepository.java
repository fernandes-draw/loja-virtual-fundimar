package com.fundimar.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundimar.backend.entities.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {}
