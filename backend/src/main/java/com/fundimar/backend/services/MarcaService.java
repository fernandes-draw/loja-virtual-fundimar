package com.fundimar.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundimar.backend.entities.Marca;
import com.fundimar.backend.repositories.MarcaRepository;

@Service
public class MarcaService {

  @Autowired
  private MarcaRepository marcaRepository;

  public List<Marca> buscarTodas() {
    return marcaRepository.findAll();
  }

  public Marca inserir(Marca marca) {
    marca.setDataCriacao(new Date());
    Marca marcaNova = marcaRepository.saveAndFlush(marca);
    return marcaNova;
  }

  public Marca alterar(Marca marca) {
    marca.setDataAtualizacao(new Date());
    return marcaRepository.saveAndFlush(marca);
  }

  public void excluir(Long id) {
    Marca marca = marcaRepository.findById(id).get();
    marcaRepository.delete(marca);
  }
}
