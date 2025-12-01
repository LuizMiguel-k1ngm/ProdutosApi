package com.luizm.produtoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizm.produtoapi.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, String>  {

}
