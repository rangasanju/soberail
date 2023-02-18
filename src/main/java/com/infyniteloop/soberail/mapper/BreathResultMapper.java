package com.infyniteloop.soberail.mapper;


import com.infyniteloop.soberail.dto.BreathResultDto;
import com.infyniteloop.soberail.model.BreathResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BreathResultMapper {

    @Mapping(source = "id", target = "recordId")
    BreathResultDto toDto(BreathResult result);

    @Mapping(source = "recordId", target = "id")
    BreathResult toEntity(BreathResultDto breathResultDto);
}
