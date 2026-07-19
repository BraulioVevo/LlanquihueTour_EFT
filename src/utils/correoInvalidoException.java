package utils;

/**
 * Exception personalizada para los correos que no cumplen con el formato.
 */
 public class correoInvalidoException extends Exception {
        
    public correoInvalidoException (String mensaje){
        super(mensaje);
    }
}
