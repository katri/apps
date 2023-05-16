package com.project.apps.appRoutine;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppRoutineMapper {
    AppRoutine toEntity(AppRoutineRequestView appRoutineRequestView);

    AppRoutineRequestView toRequestDto(AppRoutine appRoutine);
    AppRoutineResponseView toResponseDto(AppRoutine appRoutine);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppRoutine partialUpdate(AppRoutineRequestView appRoutineRequestView, @MappingTarget AppRoutine appRoutine);
}