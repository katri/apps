package com.project.apps.appRoutine;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppRoutineMapper {
    AppRoutine toEntity(AppRoutineRequestView appRoutineRequestView);

    AppRoutineResponseView toResponseDto(AppRoutine appRoutine);
    List<AppRoutineResponseView> toResponseDto(List<AppRoutine> appRoutines);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppRoutine partialUpdate(AppRoutineRequestView appRoutineRequestView, @MappingTarget AppRoutine appRoutine);
}