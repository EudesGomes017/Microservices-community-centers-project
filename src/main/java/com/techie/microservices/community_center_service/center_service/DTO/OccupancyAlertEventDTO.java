package com.techie.microservices.community_center_service.center_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OccupancyAlertEventDTO {
    private String centerId;
    private String name;
    private String location;
    private int capacity;
    private int occupancy;
}