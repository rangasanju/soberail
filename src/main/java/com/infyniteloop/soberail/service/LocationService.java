package com.infyniteloop.soberail.service;

import com.infyniteloop.soberail.model.Location;
import com.infyniteloop.soberail.response.LocationResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface LocationService {
    public LocationResponseDto findAll();

    public Location save();

    public Location findLocationById();

    public LocationResponseDto findSubLocationById();

}
