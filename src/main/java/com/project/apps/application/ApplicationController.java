package com.project.apps.application;

import com.project.apps.appRoutine.AppRoutineRequestView;
import com.project.apps.appRoutine.AppRoutineResponseView;
import com.project.apps.appRoutine.AppRoutineService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @Resource
    private AppRoutineService appRoutineService;

    @GetMapping("/new")
    public ModelAndView displayNewApplicationForm() {
        return new ModelAndView("new");
    }

    @PostMapping("/new")
    public ApplicationResponseView addApplication(@RequestBody ApplicationRequestView applicationRequestView) {
        return applicationService.addApplication(applicationRequestView);
    }

    @GetMapping("/find/application")
    public ApplicationWithRoutinesView getApplicationWithRoutines(@RequestParam String applicationName) {
        return applicationService.getApplicationWithRoutines(applicationName);
    }

    @PostMapping("/routine")
    public AppRoutineResponseView addAppRoutine(@RequestBody AppRoutineRequestView request) {
        return appRoutineService.addAppRoutine(request);
    }

    @GetMapping("/find/routine")
    public ApplicationResponseView getApplication(@RequestParam String routineName) {
        return applicationService.getApplication(routineName);
    }
}
