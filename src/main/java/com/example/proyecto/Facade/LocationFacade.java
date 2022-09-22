package com.example.proyecto.Facade;

import com.example.proyecto.Service.LocationService;
import com.example.proyecto.mapper.LocationMapper;
import com.example.proyecto.modelo.LocationDTO;


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

    public void deleteLocation(Long id) {
        locationService.deleteLocation(id);
    }


}
