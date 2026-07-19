package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Producto.*;
import model.*;
import utils.*;

/**
 * 
 */
public class LectorArchivoProductos {
    
    public ArrayList <Producto> listaProductos(String rutaArchivo){
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
            //Se abre el archivo para su lectura
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))){
    
            String linea;
            
            while ((linea = lector.readLine())!= null){
                String[] partes = linea.split(";");
                if (partes.length >=7){
                    try{
                        String tipo = partes[0].trim();
                        String id = partes[1].trim();
                        String nombre = partes[2].trim();
                        String descripcion = partes[3].trim();
                        int cantidad = Integer.parseInt(partes[4].trim());
                        double precio = Double.parseDouble(partes[5].trim());
                        String tipoEmbarcacion = partes[6].trim();
                        String tipoVehiculo = partes[6].trim();
                        
                        if(tipo.equalsIgnoreCase("Lacustre")){
                            TourLacustre lacustre = new TourLacustre();
                            lacustre.setId(id);
                            lacustre.setNombre(nombre);
                            lacustre.setDescripcion(descripcion);
                            lacustre.setCantidadDeUsuarios(cantidad);
                            lacustre.setPrecio(precio);
                            
                            lacustre.setTipoEmbarcacion(tipoEmbarcacion);
                            
                            listaProductos.add(lacustre);
                            
                        } else if (tipo.equalsIgnoreCase("Terrestre")){
                            TourTerrestre terrestre = new TourTerrestre();
                            terrestre.setId(id);
                            terrestre.setNombre(nombre);
                            terrestre.setDescripcion(descripcion);
                            terrestre.setCantidadDeUsuarios(cantidad);
                            terrestre.setPrecio(precio);
                            
                            terrestre.setTipoVehiculo(tipoVehiculo);
                            
                            listaProductos.add(terrestre);
                        }
                        
                    }catch(NumberFormatException e){
                        System.out.println("Error numerico en producto");
                    }
                }
            }
    }catch(IOException e){
            System.out.println("Error de lectura" + e.getMessage());
            e.printStackTrace();
    }
    return listaProductos;
 }
}
