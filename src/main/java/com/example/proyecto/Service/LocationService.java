package com.example.proyecto.Service;

import com.example.proyecto.Repository.LocationRepository;
import com.example.proyecto.entity.Location;
import com.example.proyecto.exception.BusinessException;
import com.example.proyecto.util.Messages;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class LocationService {
    private final LocationRepository locationRepository;
    private final Messages messages;

    public LocationService(LocationRepository locationRepository, Messages messages){
        this.locationRepository = locationRepository;
        this.messages = messages;
    }
    public Location saveLocation(Location location) {
        Optional<Location> locationConsulta = locationRepository.findById(location.getId());
        if(locationConsulta.isPresent()){
            throw new BusinessException(messages.get("location.id.duplicated"));
        }
        return locationRepository.save(location);
    }

    public Location uptadteLocation(Location location) {
        if (Objects.isNull(location.getId())) {
            throw new BusinessException(messages.get("location.id.void"));
        }
        return locationRepository.save(location);
    }


    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
