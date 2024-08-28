package com.example.shiptracking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vessels")
public class Vessel {

    @Id
    private int mmsi;
    private String shipName;
    private double latitude;
    private double longitude;
    private Integer heading; // Using Integer instead of int
    private String timeUtc;

    // Constructor
    public Vessel(int mmsi, String shipName, double latitude, double longitude, Integer heading, String timeUtc) {
        this.mmsi = mmsi;
        this.shipName = shipName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.heading = heading;
        this.timeUtc = timeUtc;
    }

    // Default constructor
    public Vessel() {
    }

    // Getters and Setters
    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public String getTimeUtc() {
        return timeUtc;
    }

    public void setTimeUtc(String timeUtc) {
        this.timeUtc = timeUtc;
    }

    @Override
    public String toString() {
        return "Vessel{" +
                "mmsi=" + mmsi +
                ", shipName='" + shipName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", heading=" + heading +
                ", timeUtc='" + timeUtc + '\'' +
                '}';
    }
}
