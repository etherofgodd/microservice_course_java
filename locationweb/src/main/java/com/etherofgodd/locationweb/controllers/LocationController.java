package com.etherofgodd.locationweb.controllers;

import com.etherofgodd.locationweb.entities.Location;
import com.etherofgodd.locationweb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationController {


    @Autowired
    LocationService locationService;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);

        String msg = "Location saved with id: " + locationSaved.getId();

        modelMap.addAttribute("msg", msg);

        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        locationService.deleteLocation(id);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {

        Location location = locationService.getLocationById(id);

        modelMap.addAttribute("location", location);

        return "updateLocation";
    }

    @RequestMapping("editLocation")
    public String editLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

        locationService.updateLocation(location);

        List<Location> locations = locationService.getAllLocations();

        modelMap.addAttribute("locations", locations);

        return "displayLocations";
    }


}
