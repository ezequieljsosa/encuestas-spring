package ar.cpci.encuestasspring.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Encuesta {

    @Id
    @NotEmpty(message = "{encuesta_nombre.vacio}")
    private String nombre;
    @Min(0)
    private int dificultad;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "encuesta_id")
    private List<Pregunta> preguntas;

    public Encuesta() {
        this.preguntas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}
//nombre_encuesta.vacio="nombre esta vacio"