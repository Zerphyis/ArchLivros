package dev.Zerphyis.ClenArch.infra.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivrosRepository extends JpaRepository<LivroEntity,Long> {

    Optional<LivroEntity> findByTitulo(String titulo);
}
