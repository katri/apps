package com.project.apps.system;

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
    public ModelAndView addApplication(@RequestBody ApplicationView applicationView) {
        return applicationService.addApplication(applicationView);
    }
}
