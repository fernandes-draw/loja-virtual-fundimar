package com.fundimar.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundimar.backend.entities.Categoria;
import com.fundimar.backend.repositories.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public List<Categoria> buscarTodas() {
    return categoriaRepository.findAll();
  }

  public Categoria inserir(Categoria categoria) {
    categoria.setDataCriacao(new Date());
    Categoria categoriaNova = categoriaRepository.saveAndFlush(categoria);
    return categoriaNova;
  }

  public Categoria alterar(Categoria categoria) {
    categoria.setDataAtualizacao(new Date());
    return categoriaRepository.saveAndFlush(categoria);
  }

  public void excluir(Long id) {
    Categoria categoria = categoriaRepository.findById(id).get();
    categoriaRepository.delete(categoria);
  }
}
