package model;

public class User {
    private int id;
    private String nome_completo;
    private String login;
    private String senha;
    private String nivel;

    public User() {
    }

    public User(int id, String nome_completo, String login, String senha, String nivel) {
        this.id = id;
        this.nome_completo = nome_completo;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel.toUpperCase();
    }
    
    
    
}
