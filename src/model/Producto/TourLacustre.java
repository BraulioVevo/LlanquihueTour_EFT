package model.Producto;

import model.Registrable;

/**
 * Representa un tour Lacustre por el lago 
 */
public class TourLacustre extends Producto implements Registrable{
    
    private String tipoEmbarcacion;
    
    /**
     * Constructor vacío
     */
    public TourLacustre(){
    }

    /**
     * 
     * @param tipoEmbarcacion
     * @param id
     * @param nombre
     * @param descripcion
     * @param cantidadDeUsuarios
     * @param precio 
     */
    
    public TourLacustre(String tipoEmbarcacion, String id, String nombre, String descripcion, int cantidadDeUsuarios, double precio) {
        super(id, nombre, descripcion, cantidadDeUsuarios, precio);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String toString(){
        return "\n=== Tour Lacustre ===" +
                super.toString()+
                "Tipo de embarcación: " + tipoEmbarcacion + "\n"
    ;}
    
    @Override
    public String registrar(){
        return "Tour Ingresado de forma Correcta"
    ;}
}
