package ar.cpci.encuestasspring;

public class EncuestaNotFoundException extends Throwable {

    public EncuestaNotFoundException(String nombre) {
        super("no existe: " + nombre);
    }
}
