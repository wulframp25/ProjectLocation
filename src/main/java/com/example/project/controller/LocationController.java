package com.example.project.controller;

import com.example.project.facade.LocationFacade;
import com.example.project.exception.DataNotFoundException;
import com.example.project.model.LocationDTO;
import com.example.project.model.UserDTO;
import com.example.project.util.Messages;
import com.example.project.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationFacade locationFacade;
    private final Messages messages;

    public LocationController(LocationFacade locationFacade, Messages messages){
        this.locationFacade = locationFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Allows you to create a location", response = LocationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Location saved successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<LocationDTO>> saveLocation ( @RequestBody LocationDTO location) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("location.save.success"), locationFacade.saveLocation(location)));
    }

    @PutMapping
    @ApiOperation(value = "Allows you to update a location", response = LocationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Location updated successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<LocationDTO>> updateLocation(@Valid @RequestBody LocationDTO location) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("location.update.success"), locationFacade.updateLocation(location)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Allows you to delete a location")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Location deleted successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<Void>> deleteLocation(@PathVariable Long id) {
        try {
            locationFacade.deleteLocation(id);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("location.delete.success")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("location.delete.error"));
        }
    }

    @GetMapping("/{idUser}")
    @ApiOperation(value = "Allows you to search for a location by user id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The location was queried successfully"),
            @ApiResponse(code = 400, message = "The request is invalid"),
            @ApiResponse(code = 500, message = "Internal error processing response")})
    public ResponseEntity<StandardResponse<List<LocationDTO>>> findByFkUser(@PathVariable long idUser) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, locationFacade.findByFkUser(idUser)));
    }

}
