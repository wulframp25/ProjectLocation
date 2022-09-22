package com.example.proyecto.mapper;
import com.example.proyecto.config.EntityMapper;
import com.example.proyecto.modelo.UserDTO;
import com.example.proyecto.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
