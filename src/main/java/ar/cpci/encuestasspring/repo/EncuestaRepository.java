package ar.cpci.encuestasspring.repo;

import ar.cpci.encuestasspring.controller.EncuestaProj;
import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;



// Si quieren pueden levantar otra pagina en el 8081 que consuma por ajax el repositorio
// y verificar que con esto no les arroja un error por CORS
@CrossOrigin(origins =  "*")
@RepositoryRestResource(path="encuesta",collectionResourceRel = "encuesta",
    excerptProjection = EncuestaProj.class)
public interface EncuestaRepository
        extends PagingAndSortingRepository<
        Encuesta,String> {

    //http://localhost:8080/api/encuesta/search
    Encuesta findByNombre(String nombre);

    @Override
//    @RestResource(exported = false)
    @Secured("ROLE_ADMIN")
    Encuesta save(Encuesta var1);

}
