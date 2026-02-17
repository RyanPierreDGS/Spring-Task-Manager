package com.portfolio.apryan.taskmanager.repository;

import com.portfolio.apryan.taskmanager.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {


}
