package com.willofd.dunit.controllers.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ivan Partola
 */
@Controller
public class WelcomeController {

    @GetMapping({"", "/"})
    public String welcome() {
        return "general/welcome";
    }
}
