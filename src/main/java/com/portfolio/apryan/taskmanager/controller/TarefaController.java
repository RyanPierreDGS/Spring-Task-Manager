package com.portfolio.apryan.taskmanager.controller;

import com.portfolio.apryan.taskmanager.model.Tarefa;
import com.portfolio.apryan.taskmanager.repository.PerfilRepository;
import com.portfolio.apryan.taskmanager.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    Tarefa tarefa = new Tarefa();

    @PostMapping("/perfil/{perfilId}")
    public ResponseEntity<Tarefa> criarTarefa(@PathVariable Integer perfilId,
                                              @RequestBody Tarefa novaTarefa){
        return perfilRepository.findById(perfilId)
                .map(perfil -> {
                    novaTarefa.setPerfil(perfil);

                    Tarefa tarefaSalva = tarefaRepository.save(novaTarefa);
                    return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/perfil/{perfilId}")
    public List<Tarefa> listarPorPerfil(@PathVariable Integer perfilId){
        return tarefaRepository.findByPerfilId(perfilId);
    }

    @DeleteMapping("/{id}/perfil/{perfilId}")
    public ResponseEntity<?> excluirTarefa(@PathVariable Integer id, @PathVariable Integer perfilId) {
        return tarefaRepository.findById(id).map(tarefa -> {

            if (tarefa.getPerfil() != null && tarefa.getPerfil().getId().equals(perfilId)) {
                tarefaRepository.delete(tarefa);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ação não permitida ou tarefa sem dono.");
            }

        }).orElse(ResponseEntity.notFound().build());
    }

}
