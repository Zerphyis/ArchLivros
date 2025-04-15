package dev.Zerphyis.ClenArch;

import dev.Zerphyis.ClenArch.domain.entitiys.livros.Livros;
import dev.Zerphyis.ClenArch.infra.gateways.RepositorioDeLivrosArquivos;

import java.time.LocalDate;

public class CleanArchArquivos {

        public static void main(String[] args) {

            RepositorioDeLivrosArquivos repositorioDeLivrosEmArquivo = new RepositorioDeLivrosArquivos();

            repositorioDeLivrosEmArquivo.cadastrarLivros(new Livros("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
            repositorioDeLivrosEmArquivo.cadastrarLivros(new Livros("1984", "George Orwell", 1949));
            repositorioDeLivrosEmArquivo.cadastrarLivros(new Livros("A Revolução dos Bichos", "George Orwell", 1945));
            repositorioDeLivrosEmArquivo.cadastrarLivros(new Livros("Dom Quixote", "Miguel de Cervantes", 1605));

            repositorioDeLivrosEmArquivo.gravaEmArquivo("livros.txt");
        }
    }


