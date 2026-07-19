package service;

import java.util.ArrayList;
import java.util.List;
import model.Producto.Producto;
import model.Producto.TourLacustre;
import model.Producto.TourTerrestre;

/**
 * Gestiona, almacena y cataloga los servicios de la agencia
 * Aplica polimorfismo guardando diferentes tipos de productos de una única lista.
 */
public class GestorProductos {
    
    private List<Producto> listaProducto;
    
    public GestorProductos(){
        this.listaProducto = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto){
        listaProducto.add(producto);
    }
    public Producto buscarProductorId(String idBuscado){
        for (Producto producto : listaProducto){
            if(producto.getId() !=null && producto.getId().equalsIgnoreCase(idBuscado)){
                
            return producto;
            }
        }
            return null;
    }
            
            
    public String resumenDeProductos(){
        
        if(listaProducto.isEmpty()){
            return "No hay productos en el sistema";
        }
        String resumen ="";
        
        for (Producto producto : listaProducto){
            if (producto instanceof TourLacustre){
                TourLacustre tourLacustre = (TourLacustre) producto;
                resumen += "Tipo detectado con instanceof: Es un tour Lacustre\n";
                resumen += tourLacustre.toString();
            
            }else if (producto instanceof TourTerrestre){
            TourTerrestre tourTerrestre = (TourTerrestre) producto;
            resumen += "Tipo detectado con instanceof: Es un tour terrestre";
            resumen += tourTerrestre.toString();
        }
            resumen +="\n~~~~~~~~~~~~~~~";
        }
        return resumen;
    }
}
