package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
@RepositoryRestResource(path="encuesta",collectionResourceRel = "encuesta",
    excerptProjection = EncuestaProj.class)
public interface EncuestaRepository
        extends PagingAndSortingRepository<
        Encuesta,String> {

    //http://localhost:8080/api/encuesta/search
    Encuesta findByNombre(String nombre);

    @Override
    @RestResource(exported = false)
    Encuesta save(Encuesta var1);

}
