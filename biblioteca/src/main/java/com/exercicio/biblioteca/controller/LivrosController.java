package com.exercicio.biblioteca.controller;

import com.exercicio.biblioteca.model.LivrosModel;
import com.exercicio.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    //Endpoints
    //Endepoints de consulta

    //Requisição Get - mostra todos os livros
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_BIBLIOTECARIO')")
    @GetMapping
    public List<LivrosModel> mostrarTodosLivros(){ return livrosService.exibirTudo();}

    //Requisição Get - mostra um livro pelo Id
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_BIBLIOTECARIO')")
    @GetMapping("/{id}")
    public Optional<LivrosModel> mostrarLivroPorId(@PathVariable Long id) { return livrosService.buscarPorId(id);}

    //Endpoint de inserção
    //Requisição PUT - insere um livro
    @PreAuthorize("hasRole('ROLE_BIBLIOTECARIO')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel inserirNovoLivro(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }
@PreAuthorize("hasRole('ROLE_BIBLIOTECARIO')")
    //Endpoint de alteração
    //Requisição PUT - altera algum dado
    @PutMapping("/{id}")
    public LivrosModel alterarLivro(@PathVariable Long id,
                                    @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id, livrosModel);
    }
@PreAuthorize("hasRole('ROLE_BIBLIOTECARIO')")
    //Endpoint de deleção
    //Requisição DELETE - remove um livro
    @DeleteMapping("/{id}")
    public void removerLivros(@PathVariable Long id){
        livrosService.apagar(id);
    }
}
