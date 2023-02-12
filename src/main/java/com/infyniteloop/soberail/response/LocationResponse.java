package com.infyniteloop.soberail.response;

import com.infyniteloop.soberail.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {
    private List<Location> locationList;
}
