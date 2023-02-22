package com.infyniteloop.soberail.service;

import com.infyniteloop.soberail.dto.LocationDto;
import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.Location;

import java.util.List;
import java.util.UUID;


public interface LocationService {
    public LocationDto createLocation(LocationDto locationDto);

    public LocationDto getLocation(UUID id) throws ResourceNotFoundException;

    public List<Location> getAllLocations();

    public void deleteLocation(UUID id);

    public Location updateLocation(UUID id, Location updatedLocation) throws ResourceNotFoundException;

}
