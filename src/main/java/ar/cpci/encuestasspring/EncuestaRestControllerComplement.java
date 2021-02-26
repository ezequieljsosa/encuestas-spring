package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
import java.util.Random;

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

}
