package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController()
public class EncuestaRestController {

    private final EncuestaRepository repository;

    EncuestaRestController(EncuestaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/encuesta")
    Page<Encuesta> all(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/encuesta/{nombre}")
    Encuesta one(@PathVariable String nombre) throws EncuestaNotFoundException {
        Optional<Encuesta> optionalEncuesta = repository.findById(nombre);
        if( optionalEncuesta.isPresent()){
            return optionalEncuesta.get();
        }
        throw new EncuestaNotFoundException(nombre);

    }

    @PostMapping("/encuesta")
    Encuesta crear(@RequestBody Encuesta encuesta){
        return  this.repository.save(encuesta);
    }

    @PutMapping ("/encuesta/{nombre}")
    Encuesta modificar(Encuesta encuesta){
        //...
        return null;
    }

}
