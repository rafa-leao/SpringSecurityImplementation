package com.rafa.seguranca.user;

public class UserDTO {
    private String nome;
    private String senha;

    public UserDTO(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    private UserDTO(){}

    public User convert() {
        return new User(nome, senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
