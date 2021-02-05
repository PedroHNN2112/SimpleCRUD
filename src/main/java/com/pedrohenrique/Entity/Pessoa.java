package com.pedrohenrique.Entity;

public class Pessoa {
    private int id;
    private String CPF;
    private String nome;
    private int idade;
    private String telefone;

    //constructor
    public Pessoa(int id, String cpf, int idade, String telefone, String nome){
        this.id = id;
        this.CPF = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.nome = nome;
    }

    //constructor default
    public Pessoa(){}

    //gets e sets:

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
