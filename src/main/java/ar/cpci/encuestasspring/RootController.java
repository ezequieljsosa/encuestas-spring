package ar.cpci.encuestasspring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class RootController {
    @GetMapping("/international")
    public String getInternationalPage() {

        return "international";
    }

    @GetMapping("/current_locale")
    public @ResponseBody  String home(Locale locale) {

        return locale.toString();
    }
}
