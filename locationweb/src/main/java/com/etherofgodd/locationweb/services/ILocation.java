package com.etherofgodd.locationweb.services;

import com.etherofgodd.locationweb.entities.Location;

import java.util.List;

public interface ILocation {

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    Location getLocationById(int id);

    void deleteLocation(int id);

    List<Location> getAllLocations();
}
