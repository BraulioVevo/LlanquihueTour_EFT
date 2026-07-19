package model;

/**
 * Contrato para las entidades del Sistema Llanquihue Tour
 */
public interface Registrable {
    
    /**
    * Registra un objeto y nos devuelve un mensaje de confirmación
    * @return mensaje de confirmación sobre el registro realizado.
    */
    public String registrar();
  
}
