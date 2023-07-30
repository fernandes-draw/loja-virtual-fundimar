package com.fundimar.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundimar.backend.entities.Pessoa;
import com.fundimar.backend.repositories.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  public List<Pessoa> buscarTodas() {
    return pessoaRepository.findAll();
  }

  public Pessoa inserir(Pessoa pessoa) {
    pessoa.setDataCriacao(new Date());
    Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
    return pessoaNova;
  }

  public Pessoa alterar(Pessoa pessoa) {
    pessoa.setDataAtualizacao(new Date());
    return pessoa = pessoaRepository.saveAndFlush(pessoa);
  }

  public void excluir(Long id) {
    Pessoa pessoa = pessoaRepository.findById(id).get();
    pessoaRepository.delete(pessoa);
  }
}
