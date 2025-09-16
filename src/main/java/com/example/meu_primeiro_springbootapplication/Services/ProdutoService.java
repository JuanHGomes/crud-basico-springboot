package com.example.meu_primeiro_springbootapplication.Services;

import com.example.meu_primeiro_springbootapplication.Exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springbootapplication.Model.Produto;
import com.example.meu_primeiro_springbootapplication.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado!"));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado!");
        }
        produtoRepository.deleteById(id);
    }
    public Produto alterarProduto(Produto produtoAtualizacao, Long id){
        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado!");
        }
        Produto produtoAtualiado = produtoRepository.findById(id).get();
        produtoAtualiado.setNome( produtoAtualizacao.getNome());
        produtoAtualiado.setPreco(produtoAtualizacao.getPreco());
        return produtoRepository.save(produtoAtualiado);
    }

}
