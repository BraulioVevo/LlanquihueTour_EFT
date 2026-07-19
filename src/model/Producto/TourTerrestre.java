package model.Producto;

import model.Producto.Producto;
import model.Registrable;

/**
 *
 */
public class TourTerrestre extends Producto implements Registrable{
    
    private String tipoVehiculo;

    /**
     * Constructor vacío 
     */
    public TourTerrestre(){
    }

    /**
     * Constructor completo para instancia un tipo de servicio turistico.
     * 
     * @param tipoVehiculo 
     * @param id
     * @param nombre
     * @param descripcion
     * @param cantidadDeUsuarios
     * @param precio 
     */
    public TourTerrestre(String tipoVehiculo, String id, String nombre, String descripcion, int cantidadDeUsuarios, double precio) {
        super(id, nombre, descripcion, cantidadDeUsuarios, precio);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    @Override
    public String toString(){
        return "\n=== Tour en Terreno ===" +
                super.toString()+
                "Tipo de vehiculo a utilizar: " + tipoVehiculo +
                "\n"
    ;}
    
    @Override
    public String registrar(){
        return "Tour en terreno ingresado al sistema.";
    }
    
}