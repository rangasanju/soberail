package com.infyniteloop.soberail.mapper;


import com.infyniteloop.soberail.dto.LocationDto;
import com.infyniteloop.soberail.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "type", target = "locationType")
    LocationDto toDto(Location location);

    @Mapping(source = "locationId", target = "id")
    @Mapping(source = "locationName", target = "name")
    @Mapping(source = "locationType", target = "type")
    Location toEntity(LocationDto locationDto);
}
