package com.project.apps.appRoutine;

import com.project.apps.application.Application;
import com.project.apps.application.ApplicationService;
import com.project.apps.web.HTMLTemplateRenderer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AppRoutineService {

    private final HTMLTemplateRenderer htmlTemplateRenderer = new HTMLTemplateRenderer();

    @Resource
    private ApplicationService applicationService;

    @Resource
    private AppRoutineMapper appRoutineMapper;

    @Resource
    private AppRoutineRepository appRoutineRepository;

    public String addAppRoutine(AppRoutineRequestView request) {
        AppRoutine routine = appRoutineMapper.toEntity(request);
        routine.setLastModified(Instant.now());

        Application application = applicationService.findApplicationBy(request.getAppCode());
        routine.setApplication(application);
        appRoutineRepository.save(routine);
        AppRoutineResponseView responseView = appRoutineMapper.toResponseDto(routine);
        try {
            return htmlTemplateRenderer.toHtml(responseView, "templates/routines/confirmation_routine.html");
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Lehekülge ei leitud";
        }
    }

    public List<AppRoutineResponseView> findAllRoutines(Long id) {
        return appRoutineMapper.toResponseDto(appRoutineRepository.findAllRoutinesForApplication(id));
    }

    public AppRoutine findByName(String routineName) {
        return appRoutineRepository.findByName(routineName);
    }
}
