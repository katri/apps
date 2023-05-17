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

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/new")
    public ModelAndView displayNewApplicationForm() {
        return new ModelAndView("new");
    }


    @GetMapping("/services/new")
    public ModelAndView displayNewServiceForm() {
        return new ModelAndView("service");
    }

    @PostMapping("/")
    public ApplicationResponseView addApplication(@RequestBody ApplicationRequestView applicationRequestView) {
        return applicationService.addApplication(applicationRequestView);
    }

    @GetMapping("/find/application")
    public ApplicationWithRoutinesView getApplicationWithRoutines(@RequestParam String applicationName) {
        return applicationService.getApplicationWithRoutines(applicationName);
    }

    @GetMapping("/{name}")
    public String getApplicationByName(@PathVariable String name) {
        return applicationService.getApplicationByName(name);
    }

    @PostMapping("/routines")
    public AppRoutineResponseView addAppRoutine(@RequestBody AppRoutineRequestView request) {
        return appRoutineService.addAppRoutine(request);
    }

    @GetMapping("/find/routines")
    public ApplicationResponseView getApplication(@RequestParam String routineName) {
        return applicationService.getApplication(routineName);
    }
}
