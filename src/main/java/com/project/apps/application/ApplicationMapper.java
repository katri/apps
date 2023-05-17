package com.project.apps.application;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
    Application toEntity(ApplicationRequestView applicationRequestView);

    ApplicationResponseView toResponseDto(Application application);
    @Mapping(target = "routineName", source = "appRoutineName")
    ApplicationResponseWithRoutineView toResponseWithRoutineInfoDto(Application application, String appRoutineName);

    @Mapping(target = "appId", source = "id")
    @Mapping(target = "appName", source = "name")
    ApplicationWithRoutinesView toResponseWithRoutinesDto(Application application);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Application partialUpdate(ApplicationRequestView applicationRequestView, @MappingTarget Application application);
}