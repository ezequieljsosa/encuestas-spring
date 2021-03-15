package ar.cpci.encuestasspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class RootController {
    @GetMapping("/international")
    public String getInternationalPage() {

        return "system/international";
    }

    @GetMapping("/error")
    public String errorpage() {
        return "system/error";
    }

    @GetMapping("/current_locale")
    public @ResponseBody  String locale(Locale locale) {

        return locale.toString();
    }
    @GetMapping("/")
    public   String home() {

        return "home";
    }
}
