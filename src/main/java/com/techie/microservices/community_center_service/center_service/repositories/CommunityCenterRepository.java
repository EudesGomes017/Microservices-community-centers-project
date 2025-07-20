package com.techie.microservices.community_center_service.center_service.repositories;

import com.techie.microservices.community_center_service.center_service.models.CommunityCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommunityCenterRepository extends MongoRepository<CommunityCenter, String> {
    List<CommunityCenter> findByMaximumCapacityGreaterThanEqual(int threshold);


    }
