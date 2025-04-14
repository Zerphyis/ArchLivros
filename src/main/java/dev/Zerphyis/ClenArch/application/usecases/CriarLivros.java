package dev.Zerphyis.ClenArch.application.usecases;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;

public class CriarLivros {
    private final RepositorioDeLivros repositorio;

    public CriarLivros(RepositorioDeLivros repositorio) {
        this.repositorio = repositorio;
    }
    public Livros cadastraLivros(Livros livros) {
        return repositorio.cadastrarLivros(livros);
    }
}
