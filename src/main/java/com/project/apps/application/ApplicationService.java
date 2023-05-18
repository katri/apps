package com.project.apps.application;

import com.project.apps.appRoutine.AppRoutine;
import com.project.apps.appRoutine.AppRoutineResponseView;
import com.project.apps.appRoutine.AppRoutineService;
import com.project.apps.validation.ValidationService;
import com.project.apps.web.HTMLTemplateRenderer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ApplicationService {
    private final HTMLTemplateRenderer htmlTemplateRenderer = new HTMLTemplateRenderer();

    @Resource
    private AppRoutineService appRoutineService;

    @Resource
    private ApplicationMapper applicationMapper;

    @Resource
    private ApplicationRepository applicationRepository;

    public String addApplication(ApplicationRequestView request) {
        ValidationService.validateRequest(request);
        Application application = applicationMapper.toEntity(request);
        application.setLastModified(Instant.now());
        applicationRepository.save(application);
        ApplicationResponseView responseView = applicationMapper.toResponseDto(application);
        try {
            return htmlTemplateRenderer.toHtml(responseView, "templates/confirmation_app.html");
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Lehekülge ei leitud";
        }
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

    public String getApplicationByName(String name) {
        ApplicationWithRoutinesView application = getApplicationWithRoutines(name);
        try {
            return htmlTemplateRenderer.toHtml(application, "templates/application.html");
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Lehekülge ei leitud";
        }
    }

    public ApplicationResponseWithRoutineView getApplication(String routineName) {
        AppRoutine appRoutine = appRoutineService.findByName(routineName);
        Application application = appRoutine.getApplication();
        return applicationMapper.toResponseWithRoutineInfoDto(application, appRoutine.getName());
    }

    public String getApplicationByRoutine(String routineName) {
        ApplicationResponseWithRoutineView application = getApplication(routineName);
        try {
            return htmlTemplateRenderer.toHtml(application, "templates/routines/routine.html");
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Lehekülge ei leitud";
        }
    }
}
