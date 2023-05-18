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

    @GetMapping("/routines/new")
    public ModelAndView displayNewServiceForm() {
        return new ModelAndView("routines/new");
    }

    @GetMapping("/search")
    public ModelAndView searchApplication() {
        return new ModelAndView("search_app");
    }

    @GetMapping("/routines/search")
    public ModelAndView searchRoutines() {
        return new ModelAndView("routines/search_routine");
    }

    @PostMapping("/")
    public ApplicationResponseView addApplication(@ModelAttribute ApplicationRequestView applicationRequestView) {
        return applicationService.addApplication(applicationRequestView);
    }

    @GetMapping("/find/application")
    public ApplicationWithRoutinesView getApplicationWithRoutines(@RequestParam String applicationName) {
        return applicationService.getApplicationWithRoutines(applicationName);
    }

    @GetMapping("/name")
    public String getApplicationByName(String name) {
        return applicationService.getApplicationByName(name);
    }

    @PostMapping("/routines")
    public AppRoutineResponseView addAppRoutine(@ModelAttribute AppRoutineRequestView request) {
        return appRoutineService.addAppRoutine(request);
    }

    @GetMapping("/routines/namecheck")
    public ApplicationResponseWithRoutineView getApplication(String routineName) {
        return applicationService.getApplication(routineName);
    }

    @GetMapping("/routines/name")
    public String getApplicationByRoutine(String name) {
        return applicationService.getApplicationByRoutine(name);
    }
}
