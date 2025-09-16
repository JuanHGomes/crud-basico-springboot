package com.example.meu_primeiro_springbootapplication.Repository;

import com.example.meu_primeiro_springbootapplication.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Long id(Long id);
}
