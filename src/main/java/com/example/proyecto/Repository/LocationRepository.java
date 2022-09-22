package com.example.proyecto.Repository;

import com.example.proyecto.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository <Location, Long> {

}
