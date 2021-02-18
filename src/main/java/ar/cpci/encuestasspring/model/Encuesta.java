package ar.cpci.encuestasspring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Encuesta {

    @Id
    private String nombre;
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
