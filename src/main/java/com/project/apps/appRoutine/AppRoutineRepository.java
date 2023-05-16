package com.project.apps.appRoutine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppRoutineRepository extends JpaRepository<AppRoutine, Long> {
    @Query("select a from AppRoutine a where a.application.id = ?1 order by a.lastModified DESC")
    List<AppRoutine> findAllRoutinesForApplication(Long id);

}