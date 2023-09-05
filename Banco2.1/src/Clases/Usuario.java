package Clases;

/**
 *
 * @author Daniel Ramirez
 * @author Santiago Jimenez
 * @version 20230903
 * 
 */
public class Usuario {
   private String Nombre;
    private String id;
    private String NumeroCuenta;

    /**
     * 
     * @param Nombre: Nombre del usuario
     * @param id: Numero de identificacion del usuario
     * @param NumeroCuenta: Numero de la cuenta de banco del usuario
     */
    public Usuario(String Nombre, String id, String NumeroCuenta) {
        this.Nombre = Nombre;
        this.id = id;
        this.NumeroCuenta = NumeroCuenta; 
    }
    /**
     * Getter
     * @return Nombre: Nombre del usuario 
     */
    public String getNombre() {
        return Nombre;
    }
    /**
     * Setter
     * @param Nombre 
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    /**
     * Getter
     * @return Id: Numero de identificacion del usuario 
     */
    public String getId() {
        return id;
    }
    /**
     * Setter
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Getter
     * @return NumeroCuenta: Numero de cuenta generado por el banco
     */
    public String getNumeroCuenta() {
        return NumeroCuenta;
    }
    /**
     * Setter
     * @param NumeroCuenta 
     */
    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    
}
