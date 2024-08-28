package com.example.shiptracking.service;

import com.example.shiptracking.model.Vessel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shiptracking.repository.VesselRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VesselService {

    @Autowired
    private VesselRepository vesselRepository;

    public List<Vessel> getAllVessels() {
        return vesselRepository.findAll();
    }

    public Vessel getVesselByMmsi(int mmsi) {
        return vesselRepository.findByMmsi(mmsi);
    }}
