package com.portfolio.apryan.taskmanager.repository;

import com.portfolio.apryan.taskmanager.dto.TaskSummaryDTO;
import com.portfolio.apryan.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<TaskSummaryDTO> findTaskSummariesByUserId(@Param("userId") Long userId);

}
