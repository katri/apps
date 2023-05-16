package com.project.apps.application;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @GetMapping("/new")
    public ModelAndView displayNewApplicationForm() {
        return new ModelAndView("new");
    }

    @PostMapping("/new")
    public ApplicationResponseView addApplication(@RequestBody ApplicationRequestView applicationRequestView) {
        return applicationService.addApplication(applicationRequestView);
    }
}
