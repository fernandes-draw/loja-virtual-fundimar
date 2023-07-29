package com.fundimar.backend.services;

import com.fundimar.backend.entities.Produto;
import com.fundimar.backend.repositories.ProdutoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> buscarTodas() {
    return produtoRepository.findAll();
  }

  public Produto inserir(Produto produto) {
    produto.setDataCriacao(new Date());
    Produto produtoNova = produtoRepository.saveAndFlush(produto);
    return produtoNova;
  }

  public Produto alterar(Produto produto) {
    produto.setDataAtualizacao(new Date());
    return produto = produtoRepository.saveAndFlush(produto);
  }

  public void excluir(Long id) {
    Produto produto = produtoRepository.findById(id).get();
    produtoRepository.delete(produto);
  }
}
