package dev.Zerphyis.ClenArch.infra.gateways;

import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.infra.persistance.LivroEntity;

public class LivrosEntityMapper {
    public LivroEntity toEntity(Livros livros){
        return new LivroEntity(livros.getTitulo(), livros.getAutor(),
                livros.getAnoPublicacao());
    }

    public Livros toDomain(LivroEntity entity){
        return new Livros(entity.getTitulo(), entity.getAutor(),
                entity.getAnoPublicacao());
    }
}
