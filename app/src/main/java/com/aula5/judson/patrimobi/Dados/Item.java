package com.aula5.judson.patrimobi.Dados;

/**
 * Created by Judson on 21/06/2018.
 */

public class Item {
    private int id;
    private String nome;
    private String localizacao;

    public Item(){

    }

    public Item(int id, String nome, String localizacao){
        id = this.id;
        nome = this.nome;
        localizacao = this.localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
