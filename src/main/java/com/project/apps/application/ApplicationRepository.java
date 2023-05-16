package com.project.apps.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query("select a from Application a where upper(a.name) = upper(?1)")
    Application findByName(String name);
}