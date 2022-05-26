package com.etherofgodd.locationweb.controllers;

import com.etherofgodd.locationweb.entities.Location;
import com.etherofgodd.locationweb.repositories.LocationRepository;
import com.etherofgodd.locationweb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationRestController {

    public final LocationService locationService;

    @Autowired
    public LocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/location")
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @PatchMapping("/location")
    public Location updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        locationService.deleteLocation(id);
    }

    @GetMapping("/location/{id}")
    public Location getSingleLocation(@PathVariable("id") int id) {
        return locationService.getLocationById(id);
    }
}
