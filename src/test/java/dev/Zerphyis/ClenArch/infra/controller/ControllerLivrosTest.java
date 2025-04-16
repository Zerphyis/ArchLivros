package dev.Zerphyis.ClenArch.infra.controller;

import dev.Zerphyis.ClenArch.application.usecases.CriarLivros;

import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDto;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDtoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerLivrosTest {
    @Mock
    private CriarLivros criarLivros;


    @InjectMocks
    private ControllerLivros controller;

    private Livros livro;
    private LivrosDto livroDto;

    @BeforeEach
     void setUp() {
        livro = new Livros("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        livroDto = new LivrosDto("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
    }

    @Test
    void deveCadastrarLivroComSucesso() {
        when(criarLivros.cadastraLivros(any(Livros.class))).thenReturn(livro);
        LivrosDtoResponse response = controller.cadastrarUsuario(livroDto);

        assertNotNull(response);
        assertEquals("O Senhor dos Anéis", response.titulo());
        assertEquals("J.R.R. Tolkien", response.autor());
    }


}