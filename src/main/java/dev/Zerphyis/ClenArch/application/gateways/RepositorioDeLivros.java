package dev.Zerphyis.ClenArch.application.gateways;

import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;

import java.util.List;

public interface RepositorioDeLivros {
    Livros cadastrarLivros(Livros livros);

    List<Livros> listarTodos();

    public Livros atualizarLivro(String titulo, Livros livroAtualizado);



}
