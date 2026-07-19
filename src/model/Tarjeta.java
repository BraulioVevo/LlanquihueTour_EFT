package model;

import utils.tarjetaInvalidaException;

/**
 * Clase que representa el medio de pago asociado al Cliente.
 * Asegura que se ingresen los 16 digitos que suelen tener las tarjetas.
 * 
 */
public class Tarjeta {
    
    private String numeroTarjeta; 
    private String tipoDeTarjeta; //ejemplo: "Credito" o "Debito"
/**
 *  Constructor de clase Tarjeta con implementación de validación de consistencia.
 * @param numeroTarjeta Cadena de 16 digitos.
 * @param tipoDeTarjeta Tipo de tarjeta de pago.
 * @throws tarjetaInvalidaException Si el numero no tiene exactamente 16 digitos o es nulo
 */
    public Tarjeta(String numeroTarjeta, String tipoDeTarjeta) throws tarjetaInvalidaException {
        //Llamamos a una validación que contenga exactamente 16 numeros y no se nulo
        validarNumero(numeroTarjeta);
        this.numeroTarjeta = numeroTarjeta;
        this.tipoDeTarjeta = tipoDeTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) throws tarjetaInvalidaException {
        validarNumero(numeroTarjeta);
        this.numeroTarjeta = numeroTarjeta;
    }
    /**
     * 
     * @param numeroTarjeta Cadena a validar
     * @throws tarjetaInvalidaException Si el nuevo numero no cumple con la validación
     */
    private void validarNumero(String numeroTarjeta) throws tarjetaInvalidaException{
         if (numeroTarjeta == null || !numeroTarjeta.matches("[0-9]{16}")){
            throw new tarjetaInvalidaException("Debe ingresar los 16 números");
        }
    }
    
    public String getTipoDeTarjeta() {
        return tipoDeTarjeta;
    }

    public void setTipoDeTarjeta(String tipoDeTarjeta) {
        this.tipoDeTarjeta = tipoDeTarjeta;
    }
    
    @Override 
    public String toString(){
        String ultimosCuatroDigitos = numeroTarjeta.substring(numeroTarjeta.length()-4);
        return "**** **** **** " + ultimosCuatroDigitos;
    }
    
}
