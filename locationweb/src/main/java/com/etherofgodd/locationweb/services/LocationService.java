package com.etherofgodd.locationweb.services;

import com.etherofgodd.locationweb.entities.Location;
import com.etherofgodd.locationweb.repositories.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocation {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationById(int id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }


}
