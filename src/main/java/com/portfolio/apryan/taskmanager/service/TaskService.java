package com.portfolio.apryan.taskmanager.service;

import com.portfolio.apryan.taskmanager.dto.TaskSummaryDTO;
import com.portfolio.apryan.taskmanager.model.Task;
import com.portfolio.apryan.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // Atualizar as tarefas
    public Task atualizarTarefa(Long id, Task descricao){
        return taskRepository.findById(id).map(task -> {
            task.setNome(task.getNome());
            task.setDescricao(task.getDescricao());
            task.setStatus(task.getStatus());
            return taskRepository.save(task);

        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }

    // Excluir as tarefas
    public void deletarTarefa(Long id){
        if(!taskRepository.existsById(id)){
            throw new RuntimeException("Tarefa não encontrada com ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    // Listar Resumo das tarefas
    public List<TaskSummaryDTO> getTarefaSummario(Long userId){
        return taskRepository.findTaskSummariesByUserId(userId);
    }


}
