package model;

import utils.rutInvalidoException;

/**
 * Clase que representa y valida el RUT de un usario o un trabajador
 * Asegura que los datos mantengan un formato valido
 */
public class Rut {
    
        private String numero;
/**
 * Constructor de la clase Rut.Valida que el formato ingresado sea el correcto
 * 
 * @param numeroRut String(cadena de texto) con el formato "12345678-K".
 * @throws rutInvalidoException En caso de que el formato no coincida con el patron numerico y guíon
 */    
    public Rut(String numeroRut) throws rutInvalidoException{
        //Validación simple: solo permite numeros y letras en el codigo verificador.(numero o K)
        if (numeroRut == null || !numeroRut.matches("[0-9]+-[0-9kK]")){
            throw new rutInvalidoException("Formato de RUT invalido.");
        }
        this.numero = numeroRut;
    }
    /**
     * @return Retorna numero rut como cadena de texto.
     */
    public String getNumero(){
        return numero;
    }
   @Override
       public String toString(){
        return "RUT: " + numero;
   }
}