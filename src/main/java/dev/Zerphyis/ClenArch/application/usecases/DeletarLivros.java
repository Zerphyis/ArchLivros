package dev.Zerphyis.ClenArch.application.usecases;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;

public class DeletarLivros {
    private final RepositorioDeLivros repositorio;

    public DeletarLivros(RepositorioDeLivros repositorio) {
        this.repositorio = repositorio;
    }

    public boolean deletarLivro(String titulo) {
        return repositorio.deletarLivro(titulo);
    }
}
