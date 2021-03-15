package ar.cpci.encuestasspring.exception;

public class EncuestaNotFoundException extends Throwable {

    public EncuestaNotFoundException(String nombre) {
        super("no existe: " + nombre);
    }
}
