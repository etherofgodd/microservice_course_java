package com.etherofgodd.locationweb.repositories;

import com.etherofgodd.locationweb.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("Select type,count(type) from Location group by type")
    public List<Object[]> findTypeAndTypeCount();
}
