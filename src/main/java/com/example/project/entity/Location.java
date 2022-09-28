package com.example.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "length")
    private String length;

    @Column(name = "current_Latitude")
    private String currentLatitude;

    @Column(name = "current_Length")
    private String currentLength;

    @Column(name = "fk_user")
    private Long fkUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", insertable = false, updatable = false)
    private User idUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(String currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public String getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(String currentLength) {
        this.currentLength = currentLength;
    }

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
