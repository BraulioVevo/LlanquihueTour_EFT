package utils;

/**
 * Excepción personalizada para una tarjeta que no cumple con el 
 * formato (ej: faltan numeros)
 */
public class tarjetaInvalidaException extends Exception {
    public tarjetaInvalidaException(String mensaje){
        super(mensaje);
    }
}
