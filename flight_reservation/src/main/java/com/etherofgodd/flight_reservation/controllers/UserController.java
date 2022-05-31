package com.etherofgodd.flight_reservation.controllers;


import com.etherofgodd.flight_reservation.entities.User;
import com.etherofgodd.flight_reservation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        LOGGER.info("Inside the show registration page();");
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        LOGGER.info("Inside the show registration method():" + user);

        userRepository.save(user);
        return "login/login";
    }


    @RequestMapping("/showLogin")
    public String showLoginPage() {
        LOGGER.info("Inside the show Login page();");

        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password, ModelMap modelMap) {
        LOGGER.info("Inside the show login method():" + email + " " + password);

        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid username or password");
        }
        return "login/login";
    }
}
