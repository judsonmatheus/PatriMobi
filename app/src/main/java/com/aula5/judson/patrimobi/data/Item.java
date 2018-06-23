package com.aula5.judson.patrimobi.data;

import java.io.Serializable;

/**
 * Created by Judson on 21/06/2018.
 */

public class Item implements Serializable{
    private int id;
    private String nome;
    private String localizacao;
    private double valor;
    private String situacao;
    private String dataAquisicao;
    private String descricao;

    public Item(){

    }

    public Item(int id, String nome, String localizacao, double valor, String situacao, String dataAquisicao, String descricao){
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.valor = valor;
        this.situacao = situacao;
        this.dataAquisicao = dataAquisicao;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
