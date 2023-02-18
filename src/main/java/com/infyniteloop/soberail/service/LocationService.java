package com.infyniteloop.soberail.service;

import com.infyniteloop.soberail.model.Location;
import com.infyniteloop.soberail.response.LocationResponse;
import org.springframework.stereotype.Service;


@Service
public interface LocationService {
    public LocationResponse findAll();

    public Location save();

    public Location findLocationById();

    public LocationResponse findSubLocationById();

}
