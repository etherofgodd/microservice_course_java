package com.etherofgodd.locationweb.repositories;

import com.etherofgodd.locationweb.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
