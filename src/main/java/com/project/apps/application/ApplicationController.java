package com.project.apps.application;

import com.project.apps.appRoutine.AppRoutineRequestView;
import com.project.apps.appRoutine.AppRoutineResponseView;
import com.project.apps.appRoutine.AppRoutineService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/find")
    public ApplicationWithRoutinesView getApplicationBy(@RequestParam String applicationName) {
        return applicationService.getApplicationBy(applicationName);
    }

    @PostMapping("/routine")
    public AppRoutineResponseView addAppRoutine(@RequestBody AppRoutineRequestView request) {
        return appRoutineService.addAppRoutine(request);
    }
}
