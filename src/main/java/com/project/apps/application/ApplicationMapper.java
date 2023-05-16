package com.project.apps.application;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
    Application toEntity(ApplicationRequestView applicationRequestView);

    ApplicationRequestView toDto(Application application);

    ApplicationResponseView toResponseDto(Application application);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Application partialUpdate(ApplicationRequestView applicationRequestView, @MappingTarget Application application);
}