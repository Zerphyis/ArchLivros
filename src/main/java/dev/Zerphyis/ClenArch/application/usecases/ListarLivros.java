package dev.Zerphyis.ClenArch.application.usecases;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;

import java.util.List;

public class ListarLivros {
    private final RepositorioDeLivros repositorio;

    public ListarLivros(RepositorioDeLivros repositorio) {
        this.repositorio = repositorio;
    }
    public List<Livros> bucarTodosLivros(){
        return this.repositorio.listarTodos();
    }

}
