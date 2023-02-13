package com.infyniteloop.soberail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("locationId")
    private UUID id = null;

    private String name = null;

    private UUID parent = null;

    private String type = null;


}
