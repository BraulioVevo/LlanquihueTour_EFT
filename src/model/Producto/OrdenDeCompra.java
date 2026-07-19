package model.Producto;

import model.Personas.Cliente;

/**
 * Clase que representa la compra de un servicio turistico por parte de un cliente.
 * Aplica composición con las clases Cliente y Producto.
 * 
 */
public class OrdenDeCompra {
    
    private String idOrden;
    private Cliente cliente;
    private Producto producto;
    private String fecha;
    
    /**
     * Constructor vacío
     */
    public OrdenDeCompra(){
    }
    
    /**
     * Constructor completo para registrar una Orden de Compra
     * @param idOrden Codigo identificador de la compra
     * @param cliente Objeto Cliente que realiza la compra
     * @param producto objeto Producto comprado
     * @param fecha Fecha en la que se realiza la venta
     */
    
    public OrdenDeCompra(String idOrden, Cliente cliente, Producto producto, String fecha) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
    }
    
    /**
     * Se obtiene el valor total de la orden. Al estar simplificada la compra 
     * el total equivale directamente al precio base del producto asociado.
     * 
     * @return Costo total de la orden de compra.
     */
    
    public double obtenerTotal(){
        if(this.producto != null){
            return this.producto.getPrecio();
        }
        return 0;
    }

    //Getters y Setters
    
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return "Orden N°: " + idOrden + " | Fecha: " + fecha
                + "\nCliente: " + (cliente !=null ? cliente.getNombre(): "N/A")
                +"\nProducto: " + (producto != null ? producto.getNombre():"N/A")
                +"\nTotal a pagar: $" + obtenerTotal();
    }
    
}
