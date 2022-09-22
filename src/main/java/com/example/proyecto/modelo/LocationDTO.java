package com.example.proyecto.modelo;

import com.example.proyecto.entity.User;

import javax.validation.constraints.NotNull;

public class LocationDTO {

    private long id;
    @NotNull
    private String latitude;
    @NotNull
    private String length;
    @NotNull
    private String currentLength;
    @NotNull
    private String currentLatitude;
    private long fkUser;
    private User idUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitud) {
        this.latitude = latitude;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getcurrentLength() {
        return currentLength;
    }

    public void setcurrentLength(String currentLength) {
        this.currentLength = currentLength;
    }

    public String getcurrentLatitude() {
        return currentLatitude;
    }

    public void setcurrentLatitude(String currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public long getFkUser() {
        return fkUser;
    }

    public void setFkUser(long fkUser) {
        this.fkUser = fkUser;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
