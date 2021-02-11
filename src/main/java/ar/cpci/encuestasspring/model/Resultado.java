package ar.cpci.encuestasspring.model;

import javax.persistence.*;

@Entity
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Encuesta encuesta;
    private String rtas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public String getRtas() {
        return rtas;
    }

    public void setRtas(String rtas) {
        this.rtas = rtas;
    }
}
