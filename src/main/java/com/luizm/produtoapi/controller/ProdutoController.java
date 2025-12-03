package com.luizm.produtoapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.luizm.produtoapi.ProdutoApiApplication;
import com.luizm.produtoapi.model.Produto;
import com.luizm.produtoapi.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoApiApplication produtoApiApplication;
	
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		System.out.println("Produto recebido: "+ produto);
		
		var id = UUID.randomUUID().toString();
		produto.setId(id);
		
		produtoRepository.save(produto);
		return produto;
	}

	public ProdutoController(ProdutoRepository produtoRepository, ProdutoApiApplication produtoApiApplication) {
		this.produtoRepository = produtoRepository;
		this.produtoApiApplication = produtoApiApplication;
	}
	
	
	@GetMapping("/{id}")
	public Produto obterPorId(@PathVariable("id") String id) {
		return produtoRepository.findById(id).orElse(null);
		
	}
	
	
	@DeleteMapping ("{id}")
	public void deletar(@PathVariable("id") String id) {
		produtoRepository.deleteById(id);
	}
	
	
	@PutMapping("{id}")
	public void atualizar(@PathVariable("id") String id,
			@RequestBody Produto produto) {
		
		produto.setId(id);
		produtoRepository.save(produto);			
		
	}
	
	
	@GetMapping
	public List<Produto> buscar(@RequestParam ("nome") String nome){
		return produtoRepository.findByNome(nome);
		
		
		
		
	}
	
	

}
