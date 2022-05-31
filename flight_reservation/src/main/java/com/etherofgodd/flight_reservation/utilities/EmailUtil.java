package com.etherofgodd.flight_reservation.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);


    private JavaMailSender sender;

    @Autowired
    public EmailUtil(JavaMailSender sender) {
        LOGGER.info("OMO, it's here sha!!!");
        this.sender = sender;
    }

    public void sendItinerary(String toAddress, String filePath) {


    }
}
