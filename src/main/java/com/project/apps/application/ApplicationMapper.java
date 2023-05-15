package com.project.apps.application;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
    Application toEntity(ApplicationView applicationView);

    ApplicationView toDto(Application application);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Application partialUpdate(ApplicationView applicationView, @MappingTarget Application application);
}