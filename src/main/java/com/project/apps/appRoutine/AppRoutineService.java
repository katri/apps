package com.project.apps.appRoutine;

import com.project.apps.application.Application;
import com.project.apps.application.ApplicationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AppRoutineService {
    @Resource
    private ApplicationService applicationService;

    @Resource
    private AppRoutineMapper appRoutineMapper;

    @Resource
    private AppRoutineRepository appRoutineRepository;

    public AppRoutineResponseView addAppRoutine(AppRoutineRequestView request) {
        AppRoutine routine = appRoutineMapper.toEntity(request);
        routine.setLastModified(Instant.now());

        Application application = applicationService.findApplicationBy(request.getAppCode());
        routine.setApplication(application);
        appRoutineRepository.save(routine);
        return appRoutineMapper.toResponseDto(routine);
    }

    public List<AppRoutineResponseView> findAllRoutines(Long id) {
        return appRoutineMapper.toResponseDto(appRoutineRepository.findAllRoutinesForApplication(id));
    }

    public AppRoutine findByName(String routineName) {
        return appRoutineRepository.findByName(routineName);
    }
}
