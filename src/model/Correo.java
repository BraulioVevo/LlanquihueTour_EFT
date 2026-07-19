package model;

import utils.correoInvalidoException;

/**
 * Clase que representa y valida una dirección de correo. 
 */

public class Correo {
    
        private String direccionCorreo;
    /**
     * @param correoValido String que valida si es que una direccion de correo contiene el signo "@"
     * @throws correoInvalidoException 
     */
    public Correo (String correoValido) throws correoInvalidoException{
        //Valdidador de correo electronico
        
        if (correoValido == null || !correoValido.matches("^(.+)@(\\S+)$")){
            throw new correoInvalidoException("Formato de correo invalido.");
    }
        this.direccionCorreo = correoValido;
    }
    /**
     * @return Retorna la dirección de correo.
     */
    public String getCorreo(){
        return direccionCorreo;
    }
    @Override
        public String toString(){
            return "Correo: " + direccionCorreo;
        }
}