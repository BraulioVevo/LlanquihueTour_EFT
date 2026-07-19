package model.Personas;

import model.Correo;
import model.Direccion;
import model.Registrable;
import model.Rut;

/**
 * Clase que representa a un empleado de la agencia Llanquihue Tour 
 * hereda de Persona e implementa la interfaz Registrable.  
 */
public class Empleado extends Persona implements Registrable{
    
    private String area;
    
   /*
    *Constructor vacio
    */
    public Empleado(){
    super();
    }
    
    /**
     * Constructor completo para instancia a un Empleado con sus datos.
     * @param area Departamento o area en la que trabaja (ej: ventas, transporte)
     * @param nombre Nombre del empleado
     * @param rut Rut validado
     * @param correo objeto Correo con su validación
     * @param contacto Teléfono de contacto 
     * @param direccion Objeto Direccion de residencia.
     */
    public Empleado(String area, String nombre, Rut rut, Correo correo, String contacto, Direccion direccion) {
        super(nombre, rut, correo, contacto, direccion);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    @Override
    public String toString(){
        return "=== Datos del Empleado ===" +
                super.toString()+
                "\nArea: " + area +"\n" ;
    }
    
    @Override
    public String registrar(){
        return "Empleado registrado correctamete";
    }
    
}
