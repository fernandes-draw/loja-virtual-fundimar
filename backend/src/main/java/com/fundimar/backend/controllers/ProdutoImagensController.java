package com.fundimar.backend.controllers;

import com.fundimar.backend.entities.ProdutoImagens;
import com.fundimar.backend.services.ProdutoImagensService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/produtoimagens")
public class ProdutoImagensController {

  @Autowired
  private ProdutoImagensService produtoimagensService;

  @GetMapping("/")
  public List<ProdutoImagens> buscarTodas() {
    return produtoimagensService.buscarTodas();
  }

  @PostMapping("/")
  public ProdutoImagens inserir(
    @RequestParam("idProduto") Long idProduto,
    @RequestParam("file") MultipartFile file
  ) {
    return produtoimagensService.inserir(idProduto, file);
  }

  @PutMapping("/")
  ProdutoImagens alterar(@RequestBody ProdutoImagens produtoimagens) {
    return produtoimagensService.alterar(produtoimagens);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
    produtoimagensService.excluir(id);
    return ResponseEntity.ok().build();
  }
}
