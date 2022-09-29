package com.example.project.facade;

import com.example.project.entity.Location;
import com.example.project.service.LocationService;
import com.example.project.mapper.LocationMapper;
import com.example.project.model.LocationDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LocationFacade {

    private final LocationService locationService;
    private final LocationMapper locationMapper;

    public LocationFacade(LocationService locationService, LocationMapper locationMapper){
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    public LocationDTO saveLocation (LocationDTO location){
        return locationMapper.toDto(locationService.saveLocation(locationMapper.toEntity(location)));
    }

    public LocationDTO updateLocation (LocationDTO location){
        return locationMapper.toDto(locationService.uptadteLocation(locationMapper.toEntity(location)));
    }

    public List<LocationDTO>  findByFkUser(Long idUser){
        return  locationMapper.toDto(locationService.findByFkUser(idUser));
    }


    public void deleteLocation(Long id) {
        locationService.deleteLocation(id);
    }


}
