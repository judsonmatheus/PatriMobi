package com.aula5.judson.patrimobi.data;

import java.io.Serializable;

/**
 * Created by Judson on 21/06/2018.
 */

public class Item implements Serializable{
    private int id;
    private String nome;
    private String localizacao;

    public Item(){

    }

    public Item(int id, String nome, String localizacao){
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
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
