package com.fundimar.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fundimar.backend.entities.Produto;
import com.fundimar.backend.entities.ProdutoImagens;
import com.fundimar.backend.repositories.ProdutoImagensRepository;
import com.fundimar.backend.repositories.ProdutoRepository;

@Service
public class ProdutoImagensService {

  @Autowired
  private ProdutoImagensRepository produtoimagensRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  public List<ProdutoImagens> buscarTodas() {
    return produtoimagensRepository.findAll();
  }

  public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
    Produto produto = produtoRepository.findById(idProduto).get();

    ProdutoImagens produtoimagens = new ProdutoImagens();

    try {
      if (!file.isEmpty()) {
        byte[] bytes = file.getBytes();

        String nomeImagem =
          String.valueOf(produto.getId()) + file.getOriginalFilename();

        Path caminho = Paths.get(
          "E:/Spring/imagens/" + nomeImagem
        );
        Files.write(caminho, bytes);
        produtoimagens.setNome(nomeImagem);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    produtoimagens.setProduto(produto);
    produtoimagens.setDataCriacao(new Date());
    produtoimagens = produtoimagensRepository.saveAndFlush(produtoimagens);

    return produtoimagens;
  }

  public ProdutoImagens alterar(ProdutoImagens produtoimagens) {
    produtoimagens.setDataAtualizacao(new Date());
    return (
      produtoimagens = produtoimagensRepository.saveAndFlush(produtoimagens)
    );
  }

  public void excluir(Long id) {
    ProdutoImagens produtoimagens = produtoimagensRepository.findById(id).get();
    produtoimagensRepository.delete(produtoimagens);
  }
}
