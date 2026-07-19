package model.Producto;

import model.Registrable;

/**
 * Clase que representa un servicio turistico ofrecido por Llanquihue Tour
 */
public class Producto implements Registrable { 
    
    private String id;
    private String nombre;
    private String descripcion;
    private int cantidadDeUsuarios;
    private double precio;
    
    /**
     * Constructor vacío
     */
    public Producto(){
    }
    /**
     * Constructor completo de Producto
     * @param id Codigo identificador del servicio 
     * @param nombre Nombre del serivicio turistico
     * @param descripcion Descripción de los servicios que se ofrecen
     * @param cantidadDeUsuarios indica la cantidad maxima de usuarios por servicio
     * @param precio Valor del servicio que se ofrece, por persona
     */
    public Producto(String id, String nombre, String descripcion, int cantidadDeUsuarios, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDeUsuarios = cantidadDeUsuarios;
        this.precio = precio;
    }

    //Getters y Setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadDeUsuarios() {
        return cantidadDeUsuarios;
    }

    public void setCantidadDeUsuarios(int cantidadDeUsuarios) {
        this.cantidadDeUsuarios = cantidadDeUsuarios;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return nombre + "(" + id + ") - | $" + precio; 
    }
    
     @Override
    public String registrar(){
        return "Producto registrado de forma correcta";
    }
}
