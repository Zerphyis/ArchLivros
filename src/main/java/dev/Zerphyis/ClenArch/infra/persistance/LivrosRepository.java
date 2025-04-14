package dev.Zerphyis.ClenArch.infra.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<LivroEntity,Long> {
}
