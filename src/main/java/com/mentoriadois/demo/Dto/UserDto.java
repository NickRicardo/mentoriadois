package com.mentoriadois.demo.Dto;

public class UserDto {
    private String nome;
    private String email;
    private long id;
    private String password;

    // construtor vazio
    public UserDto() {

    }

    //Construtor com parâmentros
    public UserDto(String nome, String email, long id, String senha) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.password = senha;
    }
    
    //Métodos getters e setters
    public String getNome() { 
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void  setId(long id) {
        this.id = id;
    }
   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;        
    }

}
