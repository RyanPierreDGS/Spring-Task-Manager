package com.portfolio.apryan.taskmanager.model;

import com.portfolio.apryan.taskmanager.enums.Priority;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String nome;

    @ManyToOne
    private Perfil perfil;

    @Column
    private String descricao;

    @Column
    private LocalDate prazo;

    @Enumerated(EnumType.STRING)
    private Priority status ;

    @Override
    public String toString() {
        return "Tarefa{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prazo=" + prazo +
                ", status=" + status +
                '}';
    }

    public Tarefa(){

    }

    public Tarefa(String nome, String descricao, LocalDate prazo, Priority status) {
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Priority getStatus() {
        return status;
    }

    public void setStatus(Priority status) {
        this.status = status;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
