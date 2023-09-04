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
        this.Cuentas_ahorros = Cuentas_ahorros;
        this.Cuentas_corrientes = Cuentas_corrientes;
    }
    public String Crearcuenta(String pin, float saldo, String tipo_cuenta, String Nombre, String id){
        if (tipo_cuenta.equals("Corriente")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta C = new Cuenta_Corriente(300000, pin, saldo, String.valueOf(numC));
            Usuario A = new Usuario(Nombre, id, String.valueOf(numC));
            Cuentas_corrientes.add(C);
            Usuarios_Corriente.add(A);
            return String.valueOf(numC);
        }
        else if (tipo_cuenta.equals("Ahorros")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta C = new Cuenta_Ahorros(pin, saldo, tipo_cuenta);
            Usuario B = new Usuario(Nombre, id, String.valueOf(numC));
            Cuentas_ahorros.add(C);
            Usuarios_Ahorro.add(B);
            return String.valueOf(numC);
        } else {
            return ("Imposible de crear cuenta con dichos parametros");
        }
    }
    
    public float RetornarSaldo(String Numcuenta, String pin, String tipo){
        if(tipo.equals("Corriente")){
            for (Cuenta cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta())){
                    return cuenta.getSaldo();
                }
            }
        }
        else if (tipo.equals("Ahorros")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta())){
                    return cuenta.getSaldo();
                }
            }
        } 
        return 34404;
    }
    public boolean Consignacion(String Numcuenta, String pin, String tipo, float Cantidad){
        if(tipo.equals("Corriente")){
            for (Cuenta cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta())){
                    if ((300000+cuenta.getSaldo()) > (-300000+Cantidad)){
                        if (Cantidad > cuenta.getSaldo() && (300000+cuenta.getSaldo()) > Cantidad){
                            if (cuenta.getSaldo() > 0){
                                Cantidad = Cantidad - cuenta.getSaldo();
                                cuenta.setSaldo(0);
                            }
                            if ((300000+cuenta.getSaldo()) > Cantidad){
                                Cantidad =-300000 + (300000-Cantidad);
                                cuenta.setSaldo(Cantidad);
                                return true;
                            } else {
                                return false;
                            }
                        }
                        else if (Cantidad <= cuenta.getSaldo()){
                            cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }
        else if (tipo.equals("Ahorros")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta())){
                    if(Cantidad <= cuenta.getSaldo()){
                        cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        return false;
        } else {
            return false;
        }
    }
    
    public boolean Retirar(String Numcuenta, String pin, String tipo, float Cantidad){
        return false;
    }
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
