package com.infyniteloop.soberail.service.impl;

import com.infyniteloop.soberail.dto.LocationDto;
import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.mapper.LocationMapper;
import com.infyniteloop.soberail.model.Location;
import com.infyniteloop.soberail.repository.LocationRepository;
import com.infyniteloop.soberail.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper mapper;

    public LocationDto createLocation(LocationDto locationDto) {
        Location location = locationRepository.save(mapper.toEntity(locationDto));
        return mapper.toDto(location);
    }

    public LocationDto getLocation(UUID id) throws ResourceNotFoundException {
        Optional<Location> location =  locationRepository.findById(id);

        return location.map(mapper::toDto)
                .orElseThrow( () -> new ResourceNotFoundException("Location id  " + id + " Not Found "));

//        if(location.isPresent())
//            return mapper.toDto(location.get());
//        else
//            throw new ResourceNotFoundException("Location id  " + id + " Not Found ");

    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void deleteLocation(UUID id) {
        locationRepository.deleteById(id);
    }

    public Location updateLocation(UUID id, Location updatedLocation) throws ResourceNotFoundException {
        Optional<Location> existingLocation = locationRepository.findById(id);
        if (existingLocation.isPresent()) {
            Location location = existingLocation.get();
            location.setName(updatedLocation.getName());
            location.setParent(updatedLocation.getParent());
            location.setType(updatedLocation.getType());
            return locationRepository.save(location);
        } else {
            throw new ResourceNotFoundException("Location id  " + id + " Not Found ");
        }
    }

}
