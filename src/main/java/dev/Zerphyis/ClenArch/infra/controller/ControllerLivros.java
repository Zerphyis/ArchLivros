package dev.Zerphyis.ClenArch.infra.controller;

import dev.Zerphyis.ClenArch.application.usecases.AtualizarLivros;
import dev.Zerphyis.ClenArch.application.usecases.CriarLivros;
import dev.Zerphyis.ClenArch.application.usecases.DeletarLivros;
import dev.Zerphyis.ClenArch.application.usecases.ListarLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDto;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/livros")
public class ControllerLivros {
    private final CriarLivros criarLivros;
    private final ListarLivros listarLivros;
    private final AtualizarLivros atualizarLivros;
    private final DeletarLivros deletarLivros;

    public ControllerLivros(CriarLivros criarLivros, ListarLivros listarLivros, AtualizarLivros atualizarLivros,DeletarLivros deletarLivros) {
        this.criarLivros = criarLivros;
        this.listarLivros = listarLivros;
        this.atualizarLivros=atualizarLivros;
        this.deletarLivros=deletarLivros;
    }

    @PostMapping
    public LivrosDtoResponse cadastrarUsuario(@RequestBody LivrosDto dto) {
        Livros salvo = criarLivros.cadastraLivros(new Livros(dto.autor(), dto.titulo(), dto.anoPublicacao()));

        return new LivrosDtoResponse(salvo.getTitulo(), salvo.getAutor(), salvo.getAnoPublicacao(), salvo.getEditora());

    }

    @GetMapping
    public List<LivrosDtoResponse> listarUsuarios() {
        return listarLivros.bucarTodosLivros().stream()
                .map(u -> new LivrosDtoResponse(u.getTitulo(), u.getAutor(), u.getAnoPublicacao(), u.getEditora()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{titulo}")
    public LivrosDtoResponse atualizarLivro(@PathVariable String titulo, @RequestBody LivrosDto dto) {
        Livros livroAtualizado = new Livros(dto.titulo(), dto.autor(), dto.anoPublicacao());
        Livros livro = atualizarLivros.atualizarLivro(titulo, livroAtualizado);
        if (livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        return new LivrosDtoResponse(livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao(), livro.getEditora());
    }
    @DeleteMapping("/{titulo}")
    public ResponseEntity<Void> deletarLivro(@PathVariable String titulo) {
        boolean deletado =deletarLivros.deletarLivro(titulo);
        if (!deletado) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
