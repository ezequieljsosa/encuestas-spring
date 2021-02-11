package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EncuestaRepository
        extends CrudRepository<Encuesta,String> {

    Encuesta findByNombre(String nombre);

}
