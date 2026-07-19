package model.Personas;

import model.Correo;
import model.Direccion;
import model.Registrable;
import model.Rut;

/**
 * Clase que representa a un proveedor externo asociado a la agencia
 * Ej: Hoteles, transporte, Alimentos.
 * Hereda de la Superclase Persona e implementa la interfaz Registrable.
 */
public class Proveedor extends Persona implements Registrable {
    
    private String empresaExterna;
    
    /**
     * Constructor vacío
     */
    public Proveedor(){
        super();
    }
    /**
     * Constructor completo para registrar un Proveedor externo
     * @param empresaExterna Nombre de la empresa
     * @param nombre Nombre del contacto de la empresa externa
     * @param rut Objeto Rut del contacto
     * @param correo Objeto Correo del contacto
     * @param contacto Teléfono de contacto
     * @param direccion Objeto Direccion de la empresa externa.
     */
    public Proveedor(String empresaExterna, String nombre, Rut rut, Correo correo, String contacto, Direccion direccion) {
        super(nombre, rut, correo, contacto, direccion);
        this.empresaExterna = empresaExterna;
    }

    public String getEmpresaExterna() {
        return empresaExterna;
    }

    public void setEmpresaExterna(String empresaExterna) {
        this.empresaExterna = empresaExterna;
    }
    /**
     * Muestra la ficha del proveedor, integrado los datos heredados
     * @return Cadena formateada con la info del proveedor.
     */
    
    @Override
    public String toString(){
     return "=== Datos del Proveedor ===" +
             super.toString()+
             "\nEmpresa externa: " + empresaExterna +
             "\n"
    ;}
    
    @Override
    public String registrar(){
        return "Proveedor registrado correctamente";
    }
}
