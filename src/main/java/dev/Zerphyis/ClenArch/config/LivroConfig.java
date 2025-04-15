package dev.Zerphyis.ClenArch.config;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;
import dev.Zerphyis.ClenArch.application.usecases.AtualizarLivros;
import dev.Zerphyis.ClenArch.application.usecases.CriarLivros;
import dev.Zerphyis.ClenArch.application.usecases.DeletarLivros;
import dev.Zerphyis.ClenArch.application.usecases.ListarLivros;
import dev.Zerphyis.ClenArch.infra.gateways.LivrosEntityMapper;
import dev.Zerphyis.ClenArch.infra.gateways.RepositorioLivrosJpa;
import dev.Zerphyis.ClenArch.infra.persistance.LivrosRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LivroConfig {

    @Bean
    CriarLivros criarUsuario(RepositorioDeLivros repositorioDeUsuario){
        return new CriarLivros(repositorioDeUsuario);
    }

    @Bean
    ListarLivros listarUsuarios(RepositorioDeLivros repositorioDeUsuario){
        return new ListarLivros(repositorioDeUsuario);
    }
    @Bean
    AtualizarLivros atualizarLivros(RepositorioDeLivros repositorioDeLivros) {
        return new AtualizarLivros(repositorioDeLivros);
    }
    @Bean
    DeletarLivros deletarLivros(RepositorioDeLivros repositorioDeLivros) {
        return new DeletarLivros(repositorioDeLivros);
    }

    @Bean
    RepositorioLivrosJpa criarRepositorioJpa(LivrosRepository repositorio, LivrosEntityMapper mapper){
        return new RepositorioLivrosJpa(repositorio, mapper);
    }

    @Bean
    LivrosEntityMapper retornaMapper(){
        return new LivrosEntityMapper();
    }
}
