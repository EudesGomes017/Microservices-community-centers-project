package com.techie.microservices.community_center_service.center_service.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.techie.microservices.community_center_service.center_service.models.enums.ResourceTypes;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.Map;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder(withPrefix = "")
public class CommunityCenterResponseDTO {

    private String id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer maximumCapacity;
    private Integer CurrentOccupation;

    @NotNull
    private Map<ResourceTypes, Integer> recurces;
}