package com.techie.microservices.community_center_service.center_service.services;


import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterRequestDTO;
import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterResponseDTO;
import com.techie.microservices.community_center_service.center_service.DTO.OccupancyAlertEventDTO;
import com.techie.microservices.community_center_service.center_service.DTO.convert.CommunityCenterMapper;
import com.techie.microservices.community_center_service.center_service.models.CommunityCenter;
import com.techie.microservices.community_center_service.center_service.repositories.CommunityCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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

    public CommunityCenter updateOccupancy(String id, int newOccupancy) {
        CommunityCenter center = repository.findById(id).orElseThrow();

        center.setCurrentOccupation(newOccupancy);
        CommunityCenter updated = repository.save(center);

        if (updated.getCurrentOccupation() >= updated.getMaximumCapacity()) {
            // Envia alerta para Kafka
            OccupancyAlertEventDTO event = OccupancyAlertEventDTO.builder()
                    .centerId(center.getId())
                    .name(center.getName())
                    .location(center.getLocation())
                    .capacity(center.getMaximumCapacity())
                    .occupancy(center.getCurrentOccupation())
                    .build();

            kafkaTemplate.send("center-occupancy-alert", center.getId(), event.toString());
        }

        return updated;
    }
}
