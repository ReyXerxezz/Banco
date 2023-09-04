/*
 * 
 * 
 */
package Clases;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Gestor_Banco {    
    private LinkedList<Usuario>Usuarios_Corriente = new LinkedList<>();
    private LinkedList<Usuario>Usuarios_Ahorro = new LinkedList<>();
    private LinkedList<Cuenta> Cuentas_corrientes = new LinkedList<>();
    private LinkedList<Cuenta> Cuentas_ahorros = new LinkedList<>();

    public Gestor_Banco() {
    }

    
    public Gestor_Banco(LinkedList<Usuario> Usuarios_Corriente, LinkedList<Usuario> Usuarios_Ahorro) {
        this.Usuarios_Corriente = Usuarios_Corriente;
        this.Usuarios_Ahorro = Usuarios_Ahorro;
    }
    public String Crearcuenta(String pin, float saldo, String tipo_cuenta, String Nombre, String id){
        if (tipo_cuenta.equals("Corriente")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta C = new Cuenta_Corriente(300000, pin, saldo, String.valueOf(numC));
            Usuario A = new Usuario(Nombre, id, String.valueOf(numC));
            Usuarios_Corriente.add(A);
            return String.valueOf(numC);
        }
        else if (tipo_cuenta.equals("Ahorros")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta C = new Cuenta_Ahorros(pin, saldo, tipo_cuenta);
            Usuario B = new Usuario(Nombre, id, String.valueOf(numC));
            Usuarios_Ahorro.add(B);
            return String.valueOf(numC);
        } else {
            return ("Imposible de crear cuenta con dichos parametros");
        }
    }
    /*
    public float RetornarSaldo(String Numcuenta, String pin, String tipo){
        if(tipo.equals("Corriente")){
            for (Usuario usuario : Usuarios_Corriente) {
                if(Numcuenta.equals(usuario.getNumeroCuenta())){
                    return 
                }
            }
  
        }else if (tipo.equals("Ahorros")){
            
        }
    }
    */
    public LinkedList<Usuario> getUsuarios_Corriente() {
        return Usuarios_Corriente;
    }

    public void setUsuarios_Corriente(LinkedList<Usuario> Usuarios_Corriente) {
        this.Usuarios_Corriente = Usuarios_Corriente;
    }

    public LinkedList<Usuario> getUsuarios_Ahorro() {
        return Usuarios_Ahorro;
    }

    public void setUsuarios_Ahorro(LinkedList<Usuario> Usuarios_Ahorro) {
        this.Usuarios_Ahorro = Usuarios_Ahorro;
    }
}
