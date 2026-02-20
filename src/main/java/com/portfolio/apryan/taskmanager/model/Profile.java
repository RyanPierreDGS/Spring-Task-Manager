package com.portfolio.apryan.taskmanager.model;

import jakarta.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    public String nome;

    public Profile() {
    }

    public Profile(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
