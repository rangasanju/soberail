package com.infyniteloop.soberail.controller;

import com.infyniteloop.soberail.dto.LocationDto;
import com.infyniteloop.soberail.exception.ResourceNotFoundException;
import com.infyniteloop.soberail.model.Location;
import com.infyniteloop.soberail.repository.LocationRepository;
import com.infyniteloop.soberail.response.BreathResultResponse;
import com.infyniteloop.soberail.response.LocationResponse;
import com.infyniteloop.soberail.service.LocationService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService service;



    /************************************************************************************************
     * http://localhost:8080/location/all
     *
     * @param
     * @return BreathResultResponseDto
     * @throws
     */
    @GetMapping()
    public LocationResponse getAllBARecords(@RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number must be greater than or equal to 0") Integer pageNo,
                                            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Page size must be greater than or equal to 1")
                                                @Max(value = 100, message = "Page size must be less than or equal to 100") Integer pageSize) {
        return service.getAllLocations(pageNo,pageSize);

    }


    @GetMapping("/{id}")
    public LocationDto getLocation(@PathVariable UUID id) throws ResourceNotFoundException {
        return service.getLocation(id);
    }

    @PostMapping
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        LocationDto savedLocation = service.createLocation(locationDto);
        return ResponseEntity.created(URI.create("/locations/" + savedLocation.getLocationId()))
                .body(savedLocation);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Location> updateLocation(@PathVariable UUID id, @RequestBody Location updatedLocation) {
//        Optional<Location> existingLocation = locationRepository.findById(id);
//        if (existingLocation.isPresent()) {
//            Location location = existingLocation.get();
//            location.setName(updatedLocation.getName());
//            location.setParent(updatedLocation.getParent());
//            location.setType(updatedLocation.getType());
//            locationRepository.save(location);
//            return ResponseEntity.ok(location);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLocation(@PathVariable UUID id) {
//        Optional<Location> location = locationRepository.findById(id);
//        if (location.isPresent()) {
//            locationRepository.delete(location.get());
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Location>> getLocations() {
//        List<Location> locations = locationRepository.findAll();
//        return ResponseEntity.ok(locations);
//    }

}
