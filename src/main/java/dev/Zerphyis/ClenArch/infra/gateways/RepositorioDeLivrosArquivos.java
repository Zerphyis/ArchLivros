package dev.Zerphyis.ClenArch.infra.gateways;

import dev.Zerphyis.ClenArch.application.gateways.RepositorioDeLivros;
import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeLivrosArquivos implements RepositorioDeLivros {
    List<Livros> livros = new ArrayList<>();

    @Override
    public Livros cadastrarLivros(Livros livro) {
        this.livros.add(livro);
        return livro;
    }

    @Override
    public List<Livros> listarTodos() {
        return this.livros;
    }

    public void gravaEmArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.livros.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
