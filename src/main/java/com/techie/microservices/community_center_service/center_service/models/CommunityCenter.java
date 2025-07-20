package com.techie.microservices.community_center_service.center_service.models;

import com.techie.microservices.community_center_service.center_service.models.enums.ResourceTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.EnumMap;
import java.util.Map;


@Document(collection = "centers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityCenter {

    @Id
    private String id;

    private String name;
    private String address;
    private String location;
    private Double latitude;
    private Double longitude;
    private Integer maximumCapacity;
    private Integer CurrentOccupation; //Ocupação atual

    // Recursos do centro
    private Map<ResourceTypes, Integer> recurces = new EnumMap<>(ResourceTypes.class);
}
