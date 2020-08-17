package com.rafa.seguranca.config.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthDTO {
    private String nome;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(this.nome, this.senha);
    }
}
