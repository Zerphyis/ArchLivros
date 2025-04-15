package dev.Zerphyis.ClenArch.application.usecases;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;

public class AtualizarLivros {
    private final RepositorioDeLivros repositorio;

    public AtualizarLivros(RepositorioDeLivros repositorio) {
        this.repositorio = repositorio;
    }

    public Livros atualizarLivro(String titulo, Livros livroAtualizado) {
        return repositorio.atualizarLivro(titulo, livroAtualizado);
    }
}
