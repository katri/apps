package com.project.apps.appService;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppServiceInfoMapper {
    AppServiceInfo toEntity(AppServiceInfoView appServiceInfoView);

    AppServiceInfoView toDto(AppServiceInfo appServiceInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AppServiceInfo partialUpdate(AppServiceInfoView appServiceInfoView, @MappingTarget AppServiceInfo appServiceInfo);
}