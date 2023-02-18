package com.infyniteloop.soberail.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDto {
    @JsonProperty("locationId")
    private UUID locationId = null;
    @JsonProperty("locationName")
    private String locationName = null;
    @JsonProperty("parent")
    private UUID parent = null;
    @JsonProperty("locationType")
    private String locationType = null;

}
