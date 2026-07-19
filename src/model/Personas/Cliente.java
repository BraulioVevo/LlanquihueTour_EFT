package model.Personas;

import model.Correo;
import model.Direccion;
import model.Registrable;
import model.Rut;
import model.Tarjeta;

/**
 * Representa a un cliente que adquiere servicios de Llanquihue Tour
 * Clase cliente que que hereda los atributos de la Superclase Persona
 */
public class Cliente extends Persona implements Registrable{
    
    private String frecuenciaCliente;
    private Tarjeta tarjeta;
    
/**
 * Constructor vacío
 */
    public Cliente(){
        super();
    }
/**
 * Constructor completo para instanciar un Cliente
 * 
 * @param frecuenciaCliente Categoria de cliente (ej: Frecuente, Primera vez)
 * @param tarjeta Objeto Tarjeta de pago
 * @param nombre Nombre completo del cliente
 * @param rut Rut valido
 * @param correo Correo valido
 * @param contacto telefono de contacto 
 * @param direccion Dirección del Cliente
 */
    public Cliente(String frecuenciaCliente, Tarjeta tarjeta, String nombre, Rut rut, Correo correo, String contacto, Direccion direccion) {
        super(nombre, rut, correo, contacto, direccion);
        this.frecuenciaCliente = frecuenciaCliente;
        this.tarjeta = tarjeta;
    }

    public String getFrecuenciaCliente() {
        return frecuenciaCliente;
    }

    public void setFrecuenciaCliente(String frecuenciaCliente) {
        this.frecuenciaCliente = frecuenciaCliente;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    @Override
    public String toString(){
        
        String infoTarjeta =(this.tarjeta != null) ? this.tarjeta.toString(): "No registrada";
        return "=== DATOS CLIENTE ===" + 
                super.toString()+ 
                "\nTipo de cliente: " + frecuenciaCliente + 
                "\nTarjeta registrada: " + infoTarjeta +"\n";
    }  
    
     @Override
    public String registrar(){
        return "Cliente " + getNombre() + " registrado de forma correcta";
    }
   
}
