package com.example.project.mapper;

import com.example.project.config.EntityMapper;
import com.example.project.entity.Location;
import com.example.project.model.LocationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface LocationMapper extends EntityMapper <LocationDTO, Location>{
}
