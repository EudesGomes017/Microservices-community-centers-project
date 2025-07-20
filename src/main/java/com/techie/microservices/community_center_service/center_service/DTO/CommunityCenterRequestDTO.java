package com.techie.microservices.community_center_service.center_service.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder(withPrefix = "")
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCenterRequestDTO {
    private String name;
    private String address;
    private String location;
    private Double latitude;
    private Double longitude;
    private Integer maximumCapacity;
    private Integer CurrentOccupation; //Ocupação atual
    private Map<String, Integer> resources;
}
