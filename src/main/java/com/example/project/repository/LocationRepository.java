package com.example.project.repository;

import com.example.project.entity.Location;
import com.example.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository <Location, Long> {


    List<Location>  findByFkUser(Long idUser);
}
