package com.project.apps.application;

import com.project.apps.appRoutine.AppRoutine;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
    Application toEntity(ApplicationRequestView applicationRequestView);

    ApplicationRequestView toDto(Application application);

    ApplicationResponseView toResponseDto(Application application);
    @Mapping(target = "routineName", source = "appRoutineName")
//    @Mapping(target = "id", source = "application.id")
//    @Mapping(target = "name", source = "application.name")
//    @Mapping(target = "description", source = "application.description")
    ApplicationResponseWithRoutineView toResponseWithRoutineInfoDto(Application application, String appRoutineName);

    @Mapping(target = "appId", source = "id")
    @Mapping(target = "appName", source = "name")
    ApplicationWithRoutinesView toResponseWithRoutinesDto(Application application);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Application partialUpdate(ApplicationRequestView applicationRequestView, @MappingTarget Application application);
}