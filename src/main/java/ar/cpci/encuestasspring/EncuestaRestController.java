package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EncuestaRestController {

    private final EncuestaRepository repository;

    EncuestaRestController(EncuestaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/encuesta")
    Iterable<Encuesta> all() {
        return repository.findAll();
    }



}
