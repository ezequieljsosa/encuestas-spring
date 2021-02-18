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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;



@Controller
public class EncuestaController {

    @Autowired
    EncuestaRepository repo;



    //http://localhost:8080/encuesta?size=5&sort=nombre,desc&page=1
    @GetMapping("/encuesta")
    public String encuestas(Model model,Pageable page) {
        Iterable<Encuesta> listadoEncuestas = repo.findAll(page);
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

    @GetMapping("/encuesta/edit")
    //@RequestParam Map<String,String> allRequestParams
    public String new_encuesta( ) {
        return "encuesta_edit";
    }

    @PostMapping("/encuesta/edit")

    public String new_encuesta( @Valid Encuesta encuesta, Model model,
                               BindingResult bindingResult) {

        repo.save(encuesta);

        return "redirect:/encuesta";
    }

}
//    @RequestParam Map<String,String> allRequestParams