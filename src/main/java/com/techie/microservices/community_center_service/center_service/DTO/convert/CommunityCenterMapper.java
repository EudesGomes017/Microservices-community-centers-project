package com.techie.microservices.community_center_service.center_service.DTO.convert;

import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterRequestDTO;
import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterResponseDTO;
import com.techie.microservices.community_center_service.center_service.models.CommunityCenter;

import static com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterResponseDTO.*;

public class CommunityCenterMapper {

    public static CommunityCenter toEntity(CommunityCenterRequestDTO dto) {
        return CommunityCenter.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .maximumCapacity(dto.getMaximumCapacity())
                .CurrentOccupation(dto.getCurrentOccupation())
                .recurces(dto.getResources())
                .build();
    }

    public static CommunityCenterResponseDTO toDTO(CommunityCenter entity) {
        return builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .maximumCapacity(entity.getMaximumCapacity())
                .CurrentOccupation(entity.getCurrentOccupation())
                .recurces(entity.getRecurces())
                .build();
    }
}
