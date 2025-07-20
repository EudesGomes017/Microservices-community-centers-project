package com.techie.microservices.community_center_service.center_service.controller;

import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterRequestDTO;
import com.techie.microservices.community_center_service.center_service.DTO.CommunityCenterResponseDTO;
import com.techie.microservices.community_center_service.center_service.models.CommunityCenter;
import com.techie.microservices.community_center_service.center_service.services.CommunityCenterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/centers")
public class CommunityCenterController {

    @Autowired
    private CommunityCenterService service;

    @Operation(summary = "Register a new community center")
    @PostMapping(value = "/create", produces = "application/json")
    public CommunityCenterResponseDTO create(@RequestBody CommunityCenterRequestDTO request) {
        return service.createCenter(request);
    }

    @PutMapping("/{id}/occupancy")
    @Operation(summary = "Update the occupancy of a community center")
    public CommunityCenter updateOccupancy(@PathVariable String id,
                                           @RequestParam int occupancy) {
        return service.updateOccupancy(id, occupancy);
    }
}

