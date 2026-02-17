package com.portfolio.apryan.taskmanager.repository;

import com.portfolio.apryan.taskmanager.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    List<Tarefa> findByPerfilId(Integer perfilId);

}
