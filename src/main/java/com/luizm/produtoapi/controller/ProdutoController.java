package com.luizm.produtoapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizm.produtoapi.model.Produto;
import com.luizm.produtoapi.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		System.out.println("Produto recebido: "+ produto);
		
		var id = UUID.randomUUID().toString();
		produto.setId(id);
		
		produtoRepository.save(produto);
		return produto;
	}

	public ProdutoController(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

}
