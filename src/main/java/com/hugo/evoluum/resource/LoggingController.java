package com.hugo.evoluum.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
 
    Logger logger = Logger.getLogger(LoggingController.class.getName());
 
    @RequestMapping("/log")
    public String index() {
    	logger.setLevel(Level.INFO);
        logger.info("An INFO Message");
 
        return "Howdy! Check out the Logs to see the output...";
    }
}
