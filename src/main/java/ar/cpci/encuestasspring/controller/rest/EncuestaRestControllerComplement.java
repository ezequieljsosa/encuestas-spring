package ar.cpci.encuestasspring.controller.rest;

import ar.cpci.encuestasspring.model.Encuesta;
import ar.cpci.encuestasspring.repo.EncuestaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
import java.util.Random;

// Extiende las funcionalidades de repo.EncuestaRepository que es un RepositoryRestResource
@RepositoryRestController
public class EncuestaRestControllerComplement {

    private EncuestaRepository repo;

    public EncuestaRestControllerComplement(EncuestaRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/encuesta/random")
    public ResponseEntity<Encuesta> random(){
        Optional<Encuesta> e = repo.findById("encuesta" + new Integer(new Random().nextInt(10)).toString() );
        return  ResponseEntity.ok( e.get());
    }

    @RequestMapping(method = RequestMethod.POST,value = "/encuesta")
    public ResponseEntity<Encuesta> crear(@RequestBody Encuesta e){
        return  ResponseEntity.ok( this.repo.save(e)  );
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/encuesta/{nombreEncuesta}/pregunta")
//    public ResponseEntity<Encuesta> crearPregunta(@PathVariable String nombreEncuesta,
//                                                  @RequestBody Pregunta pregunta){
//        Encuesta encuesta = this.repo.findById(nombreEncuesta).get();
//        encuesta.getPreguntas().add(pregunta);
//
//        return  ResponseEntity.ok(   this.repo.save(encuesta) );
//    }

}
