package com.example.project.mapper;
import com.example.project.config.EntityMapper;
import com.example.project.model.UserDTO;
import com.example.project.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
