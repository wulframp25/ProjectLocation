package com.example.proyecto.mapper;

import com.example.proyecto.config.EntityMapper;
import com.example.proyecto.entity.Location;
import com.example.proyecto.modelo.LocationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface LocationMapper extends EntityMapper <LocationDTO, Location>{
}
