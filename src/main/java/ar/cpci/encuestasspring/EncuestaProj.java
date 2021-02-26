package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import javax.validation.Valid;

@Projection(name = "encuestaProj", types = {Encuesta.class})
public interface EncuestaProj {

    String getNombre();

    @Value("#{target.getPreguntas().size()}")
    int getCantPreguntas();

    @Value("#{ (target.getPreguntas().size() > 0) ? target.getPreguntas().get(0).getTexto() : '' } ")
    String getPrimeraPreg();


}
