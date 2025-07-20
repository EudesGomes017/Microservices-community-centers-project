package com.techie.microservices.community_center_service.center_service.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class CommunityCenterRequestDTO {
    private String name;
    private String address;
    private String location;
    private int capacity;
    private int occupancy;
    private Map<String, Integer> resources;
}
