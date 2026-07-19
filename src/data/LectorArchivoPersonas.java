package data;

import model.Personas.*;
import model.*;
import utils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de la persistencia de datos.
 * lee archivos de texto .txt en este caso de las Personas
 */
public class LectorArchivoPersonas {
    
    public ArrayList <Persona> listaPersonas (String rutaArchivo){
        
        ArrayList<Persona>  listaPersonas = new ArrayList<>();
    
            //Se abre el archivo para su lectura
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))){
         
            
            //Lectura linea por linea
            String linea;
            
            while ((linea = lector.readLine())!=null){
                
                //se hace la separación de linea usando punto y coma (;)
                String [] partes =linea.split(";");
                
                if(partes.length >= 10){
                    try{
                    String tipo = partes [0].trim();
                    String nombre = partes[1].trim();
                    String stringRut = partes[2].trim();
                    String stringCorreo = partes[3].trim();
                    String contacto = partes[4].trim();
                    String calle = partes[5].trim();
                    String numero = partes[6].trim();
                    String comuna = partes[7].trim();
                    String ciudad = partes[8].trim();
                    String frecuencia = partes[9].trim();
                    String area = partes[9].trim();
                    String empresaProveedor = partes[9].trim();
                     
                    /**
                     * Instanciamos cada objeto por separado 
                     * Si el formato es incorrecto saltara la excepción al catch
                     */
                    Rut objRut = new Rut (stringRut);
                    Correo objCorreo = new Correo (stringCorreo);
                    
                    /**
                     * Para la dirección al tener atributos separados
                     * se debera ingresar por separado por otra coma en el .txt
                     */
                    Direccion objDireccion = new Direccion (calle,numero,comuna, ciudad);        
                    
                    if (tipo.equalsIgnoreCase("Cliente")){
                        Cliente c = new Cliente();
                        c.setNombre(nombre);
                        c.setRut(objRut);
                        c.setCorreo(objCorreo);
                        c.setContacto(contacto);
                        c.setDireccion(objDireccion);
                        c.setFrecuenciaCliente(frecuencia);
                        
                        listaPersonas.add(c);
                    
                    } else if (tipo.equalsIgnoreCase("Empleado")){
                        Empleado e = new Empleado();
                        e.setNombre(nombre);
                        e.setRut(objRut);
                        e.setCorreo(objCorreo);
                        e.setContacto(contacto);
                        e.setDireccion(objDireccion);
                        e.setArea(area);
                        
                        listaPersonas.add(e);
                        
                    } else if(tipo.equalsIgnoreCase("Proveedor")){
                        Proveedor p = new Proveedor();
                        p.setNombre(nombre);
                        p.setRut(objRut);
                        p.setCorreo(objCorreo);
                        p.setContacto(contacto);
                        p.setDireccion(objDireccion);
                        p.setEmpresaExterna(empresaProveedor);
                        
                        listaPersonas.add(p);
                    }
                }catch(Exception e){
                        System.out.println("Linea omitida en Personas: " + e.getMessage());
                }
            }
        }
           
            
    }catch(IOException e){
            System.out.println("Error al leer Archivo de Personas: " + e.getMessage());
    }
    return listaPersonas;
  }
}
