/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class Usuario {
   private String Nombre;
    private String id;
    private Cuenta C[];

    public Usuario() {
    }

    public Usuario(String Nombre, String id, Cuenta[] C) {
        this.Nombre = Nombre;
        this.id = id;
        this.C = C;
    }
    
    public String Crearcuenta(String pin, float saldo){
        Random random = new Random();
        int numC = random.nextInt(900000000) + 100000000;
        Cuenta c = new Cuenta(pin,saldo, String.valueOf(numC));
       return String.valueOf(numC);
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the C
     */
    public Cuenta[] getC() {
        return C;
    }

    /**
     * @param C the C to set
     */
    public void setC(Cuenta[] C) {
        this.C = C;
    }  
}
