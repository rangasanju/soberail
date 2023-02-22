package com.infyniteloop.soberail.response;

import com.infyniteloop.soberail.dto.LocationDto;
import com.infyniteloop.soberail.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationResponseList {
    private List<LocationDto> locations;
}
