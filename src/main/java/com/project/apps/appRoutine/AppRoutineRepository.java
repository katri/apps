package com.project.apps.appRoutine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppRoutineRepository extends JpaRepository<AppRoutine, Long> {
    @Query("select a from AppRoutine a where a.application.id = ?1 order by a.id ASC")
    List<AppRoutine> findAllRoutinesForApplication(Long id);

    @Query("select a from AppRoutine a where upper(a.name) = upper(?1)")
    AppRoutine findByName(String name);


}