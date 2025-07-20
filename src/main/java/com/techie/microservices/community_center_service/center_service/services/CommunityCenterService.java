package com.techie.microservices.community_center_service.center_service.services;


import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterRequestDTO;
import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterResponseDTO;
import com.techie.microservices.community_center_service.center_service.DTO.convert.CommunityCenterMapper;
import com.techie.microservices.community_center_service.center_service.models.CommunityCenter;
import com.techie.microservices.community_center_service.center_service.repositories.CommunityCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommunityCenterService {

    @Autowired
    private CommunityCenterRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public CommunityCenterResponseDTO createCenter(CommunityCenterRequestDTO request) {
        CommunityCenter center = CommunityCenterMapper.toEntity(request);
        CommunityCenter salve = repository.save(center);
        return CommunityCenterMapper.toDTO(salve);
    }
}
