package com.project.apps.application;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ApplicationService {

    @Resource
    private ApplicationMapper applicationMapper;

    @Resource
    private ApplicationRepository applicationRepository;

    public ApplicationResponseView addApplication(ApplicationRequestView request) {
        Application application = applicationMapper.toEntity(request);
        application.setLastModified(Instant.now());
        applicationRepository.save(application);
        ApplicationResponseView response = applicationMapper.toResponseDto(application);
        return response;
    }

    public Application findApplicationBy(Long appCode) {
        return applicationRepository.findById(appCode).get();
    }
}
