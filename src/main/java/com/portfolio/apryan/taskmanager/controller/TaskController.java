package com.portfolio.apryan.taskmanager.controller;

import com.portfolio.apryan.taskmanager.dto.TaskSummaryDTO;
import com.portfolio.apryan.taskmanager.model.Task;
import com.portfolio.apryan.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizarTarefa(@PathVariable Long id,
                                                @RequestBody Task descricao) {
        Task taskAtualizada = taskService.atualizarTarefa(id, descricao);
        return ResponseEntity.ok(taskAtualizada);
    }

    @GetMapping("/user/{userId}/summary")
    public ResponseEntity<List<TaskSummaryDTO>> getTaskSummaries(@PathVariable Long userId) {
        List<TaskSummaryDTO> summaries = taskService.getTarefaSummario(userId);
        return ResponseEntity.ok(summaries);
    }

    @DeleteMapping("/user/{userId}/summary")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

}
