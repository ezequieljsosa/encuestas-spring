package ar.cpci.encuestasspring.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String nombre) {
        super("no existe: " + nombre);
    }
}
