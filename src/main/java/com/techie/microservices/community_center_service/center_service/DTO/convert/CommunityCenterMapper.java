package com.techie.microservices.community_center_service.center_service.DTO.convert;

import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterRequestDTO;
import com.techie.microservices.community_center_service.center_service.models.CommunityCenter;

public class CommunityCenterMapper {

    public static CommunityCenter toEntity(CommunityCenterRequestDTO dto) {
        return CommunityCenter.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .maximumCapacity(dto.getMaximumCapacity())
                .CurrentOccupation(dto.getCurrentOccupation())
                .resources(dto.getResources())
                .build();
    }
}
