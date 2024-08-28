package com.example.shiptracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shiptracking.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Long> {
    Vessel findByMmsi(int mmsi);
}
