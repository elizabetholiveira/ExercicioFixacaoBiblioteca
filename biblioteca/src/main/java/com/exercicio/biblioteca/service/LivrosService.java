package com.exercicio.biblioteca.service;

import com.exercicio.biblioteca.model.LivrosModel;
import com.exercicio.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    LivrosRepository livrosRepository;

    //método para exibir todos os livros
    public List<LivrosModel> exibirTudo(){ return livrosRepository.findAll();}

    //método para exibir um livro específico
    public Optional<LivrosModel> buscarPorId(Long id){ return livrosRepository.findById(id);}

    //método para cadastrar um novo livro
    public LivrosModel cadastrar(LivrosModel livrosModel){ return livrosRepository.save(livrosModel);}

    //método para alterar dado de um livro
    public LivrosModel alterar(Long id, LivrosModel livrosModel){

        LivrosModel livros = buscarPorId(id).get();

        if (livrosModel.getNome() != null){
            livros.setNome(livrosModel.getNome());
        }
        if (livrosModel.getAutor() != null){
            livros.setAutor(livrosModel.getAutor());
        }
        if (livrosModel.getData() != null){
            livros.setData(livrosModel.getData());
        }
        if (livrosModel.getCodigo() != null){
            livros.setCodigo(livrosModel.getCodigo());
        }

        return livrosRepository.save(livros);
    }

    //método para deletar um livro
    public void apagar(Long id){ livrosRepository.deleteById(id);}
}
