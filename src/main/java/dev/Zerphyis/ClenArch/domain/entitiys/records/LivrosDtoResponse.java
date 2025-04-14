package dev.Zerphyis.ClenArch.domain.entitiys.records;

import dev.Zerphyis.ClenArch.domain.entitiys.Editora;

public record LivrosDtoResponse(String titulo, String autor, Integer anoPublicacao,
                                Editora editora){
}
