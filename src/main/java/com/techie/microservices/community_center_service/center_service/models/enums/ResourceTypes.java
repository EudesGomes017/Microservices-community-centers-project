package com.techie.microservices.community_center_service.center_service.models.enums;

public enum ResourceTypes {

    DOCTOR(4),
    VOLUNTARY(3),
    MEDICAL_KIT(7),
    VEHICLE(5),
    BASIC_BASKET(2);

    private final int points;

    ResourceTypes(int points) {
        this.points = points;
    }
}
