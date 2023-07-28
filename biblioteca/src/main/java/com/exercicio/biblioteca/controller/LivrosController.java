package com.exercicio.biblioteca.controller;

import com.exercicio.biblioteca.model.LivrosModel;
import com.exercicio.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    //Endpoints
    //Endepoints de consulta

    //Requisição Get - mostra todos os livros
    @GetMapping(path = "/livros")
    public List<LivrosModel> mostrarTodosLivros(){ return livrosService.exibirTudo();}

    //Requisição Get - mostra um livro pelo Id
    @GetMapping(path = "/livros/{id}")
    public Optional<LivrosModel> mostrarLivroPorId(@PathVariable Long id) { return livrosService.buscarPorId(id);}

    //Endpoint de inserção
    //Requisição PUT - insere um livro
    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel inserirNovoLivro(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }

    //Endpoint de alteração
    //Requisição PUT - altera algum dado
    @PutMapping(path = "/livros/{id}")
    public LivrosModel alterarLivro(@PathVariable Long id,
                                    @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id, livrosModel);
    }

    //Endpoint de deleção
    //Requisição DELETE - remove um livro
    @DeleteMapping(path = "/livros/{id}")
    public void removerLivros(@PathVariable Long id){
        livrosService.apagar(id);
    }
}
