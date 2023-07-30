package com.fundimar.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundimar.backend.entities.Permissao;
import com.fundimar.backend.repositories.PermissaoRepository;

@Service
public class PermissaoService {

  @Autowired
  private PermissaoRepository permissaoRepository;

  public List<Permissao> buscarTodas() {
    return permissaoRepository.findAll();
  }

  public Permissao inserir(Permissao permissao) {
    permissao.setDataCriacao(new Date());
    Permissao permissaoNova = permissaoRepository.saveAndFlush(permissao);
    return permissaoNova;
  }

  public Permissao alterar(Permissao permissao) {
    permissao.setDataAtualizacao(new Date());
    return permissaoRepository.saveAndFlush(permissao);
  }

  public void excluir(Long id) {
    Permissao permissao = permissaoRepository.findById(id).get();
    permissaoRepository.delete(permissao);
  }
}
