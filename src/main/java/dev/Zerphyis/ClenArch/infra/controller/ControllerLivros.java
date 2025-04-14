package dev.Zerphyis.ClenArch.infra.controller;

import dev.Zerphyis.ClenArch.application.usecases.CriarLivros;
import dev.Zerphyis.ClenArch.application.usecases.ListarLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDto;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDtoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/livros")
public class ControllerLivros {
    private final CriarLivros criarLivros;
    private final ListarLivros listarLivros;

    public ControllerLivros(CriarLivros criarLivros, ListarLivros listarLivros) {
        this.criarLivros = criarLivros;
        this.listarLivros = listarLivros;
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
}
