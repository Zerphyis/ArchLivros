package dev.Zerphyis.ClenArch.domain.entitiys.livros;

import dev.Zerphyis.ClenArch.domain.entitiys.Editora;


public class FabricaLivros {
    private Livros livros;

    public Livros comNomeAutor(String nome, String autor, Integer anoPublicacao){
        this.livros = new Livros(nome, autor, anoPublicacao);
        return this.livros;
    }

    public Livros incluiEndereco(String nome) {
        this.livros.setEditora(new Editora(nome));
        return this.livros;
    }

}
