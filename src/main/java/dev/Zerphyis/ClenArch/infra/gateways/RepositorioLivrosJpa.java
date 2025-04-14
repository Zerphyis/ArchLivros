package dev.Zerphyis.ClenArch.infra.gateways;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.infra.persistance.LivroEntity;
import dev.Zerphyis.ClenArch.infra.persistance.LivrosRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioLivrosJpa implements RepositorioDeLivros {
    private final LivrosRepository repositorio;
    private final LivrosEntityMapper mapper;

    public RepositorioLivrosJpa(LivrosRepository repositorio, LivrosEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Livros cadastrarLivros(Livros usuario) {
        LivroEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Livros> listarTodos() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
