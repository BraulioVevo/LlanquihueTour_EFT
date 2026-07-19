package app;

import data.*;
import service.*;
import model.Personas.*;
import model.Producto.*;
import model.*;
import model.Registrable;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===SISTEMA DE LLANQUIHUE TOUR ===\n");
        
        //Instanciamos las clases lectoras
        LectorArchivoPersonas lectorPersonas = new LectorArchivoPersonas();
        LectorArchivoProductos lectorProductos = new LectorArchivoProductos();
        
        //Instanciamos los gestores del package service
        GestorPersonas gestorPersonas = new GestorPersonas();
        GestorProductos gestorProductos = new GestorProductos();
        
        //Leemos la información desde los archivos .txt
        ArrayList<Persona> listaDePersonas = lectorPersonas.listaPersonas("personas.txt");
        ArrayList<Producto> listaDeProductos = lectorProductos.listaProductos("productos.txt");
        List <Registrable> historialGeneral = new ArrayList<>();
        
        //pasamos los datos leídos a los gestores
        for(Persona persona : listaDePersonas){
            gestorPersonas.agregarPersona(persona);
            historialGeneral.add(persona);
        }
        for(Producto producto : listaDeProductos){
            gestorProductos.agregarProducto(producto);
            historialGeneral.add(producto);
        }
        
        System.out.println("Datos cargados de forma correcta.");
        
        int opcion = 0;
        do {
            System.out.println("\n--- Menú de administración ");
            System.out.println("\nSeleccione una opción: ");
            System.out.println("1. Mostrar todos los registros de Personas");
            System.out.println("2. Mostrar todos los registros de Productos");
            System.out.println("3. Registrar un nuevo Cliente");
            System.out.println("4. Buscar Persona por RUT");
            System.out.println("5. Mostrar historial general");
            System.out.println("6. Salir");
        
        try{
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    System.out.println("\t====================================");
                    System.out.println("\t RESUMEN DE ELEMENTOS ENCONTRADOS");
                    System.out.println("\t====================================");
                    
                    System.out.println("--- Personas ---");
                    for (Persona persona : listaDePersonas){
                        if (persona instanceof Cliente){
                            System.out.println("Cliente: " + persona.toString());
                        }else if(persona instanceof Empleado){
                            System.out.println("Empleado: " + persona.toString());
                        }else if(persona instanceof Proveedor){
                            System.out.println("Proveedor: " + persona.toString());
            }
        }
        break;
        
        case 2:
            
            System.out.println("\t====================================");
            System.out.println("\t RESUMEN DE ELEMENTOS ENCONTRADOS");
            System.out.println("\t====================================");
            
            System.out.println("\n--- Productos/Servicios ---");
            for (Producto producto : listaDeProductos){
                if (producto instanceof TourLacustre){
                    System.out.println("Tour Lacustre: " + producto.toString());
                } else if(producto instanceof TourTerrestre){
                    System.out.println("Tour Terrestre: " + producto.toString());
                }
            }
            break;
            
        case 3: 
            System.out.println("\n==============================");
            System.out.println("Ingresar nuevo cliente");
            System.out.println("==============================");
            
            try{
                System.out.println("Ingrese nombre completo: ");
                String nombre = scanner.nextLine();
                
                System.out.println("Ingrese Rut(con guíon y digito verificador)");
                String stringRut = scanner.nextLine();
                Rut objRut = new Rut(stringRut);
           
                System.out.println("Ingresar Correo electronico: ");
                String stringCorreo = scanner.nextLine();
                Correo objCorreo = new Correo(stringCorreo);
                
                System.out.println("Ingrese telefono de contacto: ");
                String contacto = scanner.nextLine();
                
                System.out.println("Ingrese datos de dirección: ");
                System.out.println("Calle: "); String calle = scanner.nextLine();
                System.out.println("Número: "); String numero = scanner.nextLine();
                System.out.println("Comuna: "); String comuna = scanner.nextLine();
                System.out.println("Ciudad: "); String ciudad = scanner.nextLine();
                Direccion objDireccion = new Direccion (calle,numero,comuna,ciudad);
                
                //Usamos la clase Tarjeta 
                System.out.println("Ingrese datos de tarjeta de pago: ");
                System.out.println("Número de tarjeta (16 digitos): ");
                String numeroTarjeta = scanner.nextLine();
                System.out.println("Tipo de Tarjeta (Credito o Debito)");
                String tipoTarjeta = scanner.nextLine();
                
                Tarjeta objTarjeta = new Tarjeta(numeroTarjeta,tipoTarjeta);
                
                //instanciamos el nuevo cliente
                
                Cliente nuevoCliente = new Cliente();
                nuevoCliente.setNombre(nombre);
                nuevoCliente.setRut(objRut);
                nuevoCliente.setCorreo(objCorreo);
                nuevoCliente.setContacto(contacto);
                nuevoCliente.setDireccion(objDireccion);
                nuevoCliente.setTarjeta(objTarjeta);
                nuevoCliente.setFrecuenciaCliente("Primera vez en Llanquihue Tour");
                
                //Se agrega un cliente nuevo tanto a la lista como al gestor.
                listaDePersonas.add(nuevoCliente);
                gestorPersonas.agregarPersona(nuevoCliente);
                historialGeneral.add(nuevoCliente);
                
                System.out.println("\n Agregado: " + nuevoCliente.registrar());
            
            } catch (Exception e){
                System.out.println("\nError al ingresar cliente: " + e.getMessage());
                System.out.println("Registro cancelado, favor volver a intentar");
            }
            break;
            
        case 4:
            System.out.println("\n===============================");
            System.out.println("Buscar personas por RUT");
            System.out.println("==================================");
            System.out.println("Ingrese el Rut por buscar (ej: 12345678-k");
            String rutBuscar = scanner.nextLine();
            
            Persona encontrada = gestorPersonas.buscarPersonaRut(rutBuscar);
            if(encontrada != null){
                System.out.println("\nRut encontrado");
                System.out.println(encontrada.toString());
            } else {
                System.out.println("\nNo se encontró el Rut ingresado");
            }
            break;
        case 5:
            System.out.println("\n\t===========================");
            System.out.println("\t HISTORIAL GENERAL");
            System.out.println("\t===========================");
            
            for (Registrable item : historialGeneral){
                if (item instanceof Persona){
                    System.out.println("Historial de Personas->" + item.toString());
                }else if(item instanceof Producto){
                    System.out.println("Historial de Producto ->" + item.toString());
                }
            }
                    break;
                    
            
        case 6:
            System.out.println("Saliendo del Sistema Llanquihue Tour");
            break;
            
        default:
            System.out.println("Opción invalida");
            }
        }catch (NumberFormatException e){
            System.out.println("Favor, ingrese un número valido");
        }
         
        }while (opcion != 6);
        
        scanner.close();
    }
}

