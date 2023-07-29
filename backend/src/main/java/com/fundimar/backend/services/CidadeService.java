package com.fundimar.backend.services;

import com.fundimar.backend.entities.Cidade;
import com.fundimar.backend.repositories.CidadeRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

  @Autowired
  private CidadeRepository cidadeRepository;

  public List<Cidade> buscarTodas() {
    return cidadeRepository.findAll();
  }

  public Cidade inserir(Cidade cidade) {
    cidade.setDataCriacao(new Date());
    Cidade cidadeNova = cidadeRepository.saveAndFlush(cidade);
    return cidadeNova;
  }

  public Cidade alterar(Cidade cidade) {
    cidade.setDataAtualizacao(new Date());
    return cidade = cidadeRepository.saveAndFlush(cidade);
  }

  public void excluir(Long id) {
    Cidade cidade = cidadeRepository.findById(id).get();
    cidadeRepository.delete(cidade);
  }
}
