package utils;

/**
 * Excepción personalizada para RUT invalido
 */
public class rutInvalidoException extends Exception {
    
    public rutInvalidoException(String mensaje){
        super(mensaje);
        
    }
}
