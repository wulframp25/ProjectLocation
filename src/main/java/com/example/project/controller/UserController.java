package com.example.project.controller;

import com.example.project.facade.UserFacade;
import com.example.project.exception.DataNotFoundException;
import com.example.project.model.UserDTO;
import com.example.project.util.Messages;
import com.example.project.util.StandardResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;
    private final Messages messages;

    public UserController(UserFacade userFacade, Messages messages){
        this.userFacade= userFacade;
        this.messages= messages;
    }

    @PostMapping
    @ApiOperation(value = "Allows you to create a User", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User saved successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<UserDTO>> saveUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("user.save.success"), userFacade.saverUser(user)));
    }

    @PutMapping
    @ApiOperation(value = "Allows you to update a User", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User updated successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<UserDTO>> updateUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("user.update.success"), userFacade.updateUser(user)));
    }

    @DeleteMapping
    @ApiOperation(value = "Allows you to delete a User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User deleted successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<Void>> deleteUser(@PathVariable Long id) {
        try {
            userFacade.deleteUser(id);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("user.delete.success")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("user.delete.error"));
        }
    }


    @GetMapping("login/{email}/{password}")
    @ApiOperation(value = "Allows you to search for a user by email and password", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The user was queried successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<UserDTO>> findUserByEmail(@PathVariable String email, @PathVariable String password) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, userFacade.findUserByEmail(email, password)));
    }
}
