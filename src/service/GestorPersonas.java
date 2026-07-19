package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Personas.*;
import model.Personas.Persona;

/**
 * Clase encargada de leer datos desde archivo .txt
 */

public class GestorPersonas {
    
    /**
     * Se utilizara Try-with-resources para asegurar el cierre del flujo de datos.
     * 
     * @param rutaArchivo ruta del archivo .txt
     * @return ArrayList con los objetos Cliente validado e instanciado.
     */
    
    private List <Persona> listaPersona;
    /**
     * Constructor 
     * 
     * Crea lista vacía con new ArrayList<>()
     * Se utiliza ArrayList ya que puede crecer de forma automatica
     * a medida que se agregan los nuevos elementos.
     */
    public GestorPersonas(){
        listaPersona = new ArrayList<>();
    }
    /**
     * Agrega una persona a la lista. 
     * Al tener el parametro de tipo Persona, acepta cualquier objeto 
     * que herede esa clase, en este caso (Cliente, Empleado o Proveedor)
     * 
     * @param personas La Persona que se agrega al ArrayList(segun su tipo).
     */
    public void agregarPersona(Persona personas){
        listaPersona.add(personas);
    }
    public Persona buscarPersonaRut(String rutBuscado){
        for(Persona persona : listaPersona){
            if(persona.getRut()!= null && persona.getRut().getNumero().equalsIgnoreCase(rutBuscado)){
                return persona;
            }
        }
        return null;
    }
    
    public String resumenDePersonas(){
        
        if(listaPersona.isEmpty()){
            return "No hay usuarios registrados";
        }
        String resumen = "";
        
        for(Persona personas : listaPersona){
            
            if (personas instanceof Empleado){
                Empleado empleado = (Empleado) personas;
                resumen +="Tipo detectado con instanceof: Es un Empleado\n";
                resumen += empleado.toString();
            
            } else if (personas instanceof Proveedor){
                Proveedor proveedor = (Proveedor) personas;
                resumen +="Tipo detectado con instanceof: Es un Proveedor\n";
                resumen += proveedor.toString();
            
            } else if ( personas instanceof Cliente){
                Cliente cliente = (Cliente) personas;
                resumen +="Tipo detectado con instanceof: Es un Cliente\n";
                resumen += cliente.toString();
            }
                resumen +="\n~~~~~~~~~~~~~~~";
        }
        return resumen;
    }    
}
