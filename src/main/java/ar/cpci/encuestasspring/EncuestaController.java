package ar.cpci.encuestasspring;

//get("/encuesta", (request, response) -> {
//        Map<String, Object> map = new HashMap<>();
//        EncuestaRepository repo = createEncuestaRepo();
//        Collection<Encuesta> encuestas = repo.all();
//        map.put("encuestas", encuestas);
//        return engine.render(new ModelAndView(map, "encuestas"));
//        });

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EncuestaController {

    @Autowired
    EncuestaRepository repo;

    @GetMapping("/encuesta")
    public String encuestas(Model model) {
        Iterable<Encuesta> listadoEncuestas = repo.findAll();
        model.addAttribute("encuestas",listadoEncuestas);
        return "encuestas";
    }

    @GetMapping("/encuesta/{encuestaName}")
    public String encuestas(@PathVariable String encuestaName, Model model) {
        Optional<Encuesta> encuesta = repo.findById(encuestaName);
        if(encuesta.isPresent()){
            model.addAttribute("encuesta",encuesta.get());
        }
        return "encuesta";
    }

}
