package com.project.apps.application;

import com.project.apps.appRoutine.AppRoutine;
import com.project.apps.appRoutine.AppRoutineResponseView;
import com.project.apps.appRoutine.AppRoutineService;
import com.project.apps.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ApplicationService {
    @Resource
    private AppRoutineService appRoutineService;

    @Resource
    private ApplicationMapper applicationMapper;

    @Resource
    private ApplicationRepository applicationRepository;

    public ApplicationResponseView addApplication(ApplicationRequestView request) {
        ValidationService.validateRequest(request);
        Application application = applicationMapper.toEntity(request);
        application.setLastModified(Instant.now());
        applicationRepository.save(application);
        return applicationMapper.toResponseDto(application);
    }

    public Application findApplicationBy(Long appCode) {
        return applicationRepository.findById(appCode).get();
    }

    public ApplicationWithRoutinesView getApplicationWithRoutines(String applicationName) {
        Application application = applicationRepository.findByName(applicationName);
        ApplicationWithRoutinesView response = applicationMapper.toResponseWithRoutinesDto(application);
        List<AppRoutineResponseView> routines = appRoutineService.findAllRoutines(application.getId());
        response.setRoutines(routines);
        return response;
    }

    public ApplicationResponseView getApplication(String serviceName) {
        AppRoutine appRoutine = appRoutineService.findByName(serviceName);
        Application application = appRoutine.getApplication();
        return applicationMapper.toResponseDto(application);
    }
}
