package dev.Zerphyis.ClenArch.infra.controller;

import dev.Zerphyis.ClenArch.application.usecases.AtualizarLivros;
import dev.Zerphyis.ClenArch.application.usecases.CriarLivros;
import dev.Zerphyis.ClenArch.application.usecases.DeletarLivros;
import dev.Zerphyis.ClenArch.application.usecases.ListarLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDto;
import dev.Zerphyis.ClenArch.domain.entitiys.records.LivrosDtoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerLivrosTest {
    @Mock
    private CriarLivros criarLivros;

    @Mock
    private ListarLivros listarLivros;

    @Mock
    private AtualizarLivros atualizarLivros;

    @Mock
    private DeletarLivros deletarLivros;

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

    @Test
    void deveListarLivrosComSucesso() {
        when(listarLivros.bucarTodosLivros()).thenReturn(Collections.singletonList(livro));
        List<LivrosDtoResponse> response = controller.listarUsuarios();

        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertEquals("O Senhor dos Anéis", response.get(0).titulo());
    }

    @Test
    void deveAtualizarLivroComSucesso() {
        when(atualizarLivros.atualizarLivro(anyString(), any(Livros.class))).thenReturn(livro);
        LivrosDtoResponse response = controller.atualizarLivro("O Senhor dos Anéis", livroDto);

        assertNotNull(response);
        assertEquals("O Senhor dos Anéis", response.titulo());
    }

    @Test
    void deveLancarErroAoAtualizarLivroInexistente() {
        when(atualizarLivros.atualizarLivro(anyString(), any(Livros.class))).thenReturn(null);

        assertThrows(ResponseStatusException.class, () -> {
            controller.atualizarLivro("Livro Inexistente", livroDto);
        });
    }

    @Test
    void deveDeletarLivroComSucesso() {
        when(deletarLivros.deletarLivro(anyString())).thenReturn(true);
        ResponseEntity<Void> response = controller.deletarLivro("O Senhor dos Anéis");

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void deveLancarErroAoDeletarLivroInexistente() {
        when(deletarLivros.deletarLivro(anyString())).thenReturn(false);

        assertThrows(ResponseStatusException.class, () -> {
            controller.deletarLivro("Livro Inexistente");
        });
    }

}