package Clases;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Ramirez
 * @author Santiago Jimenez
 * @version 20230903
 * 
 */
public class Gestor_Banco {    
    
    private LinkedList<Usuario>Usuarios_Corriente = new LinkedList<>();
    private LinkedList<Usuario>Usuarios_Ahorro = new LinkedList<>();
    private LinkedList<Cuenta_Corriente> Cuentas_corrientes = new LinkedList<>();
    private LinkedList<Cuenta_Ahorros> Cuentas_ahorros = new LinkedList<>();

    /**
     * 
     * @param Usuarios_Corriente
     * @param Usuarios_Ahorro
     * @param Cuentas_corrientes
     * @param Cuentas_ahorros 
     */
    public Gestor_Banco(LinkedList<Usuario> Usuarios_Corriente, LinkedList<Usuario> Usuarios_Ahorro, LinkedList<Cuenta_Corriente> Cuentas_corrientes, LinkedList<Cuenta_Ahorros> Cuentas_ahorros) {
        this.Usuarios_Corriente = Usuarios_Corriente;
        this.Usuarios_Ahorro = Usuarios_Ahorro;
        this.Cuentas_ahorros = Cuentas_ahorros;
        this.Cuentas_corrientes = Cuentas_corrientes;
    }

    public Gestor_Banco() {
    }
    
    /**
     * 
     * @param pin: Pin de la cuenta
     * @param saldo: Fondos de la cuenta
     * @param tipo: Tipo de cuenta
     * @param Nombre: Nombre del usuario dueño de la cuenta
     * @param id: Numero de identificacion del dueño de la cuenta
     * @return  NumCuenta: Retorna el Numero de cuenta generado aleatoriamente por el sistema
     */
    public String Crearcuenta(String pin, float saldo, String tipo, String Nombre, String id){
        if (tipo.equals("Corriente") || tipo.equals("corriente") || tipo.equals("CORRIENTE")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta_Corriente C = new Cuenta_Corriente(300000, pin, saldo, String.valueOf(numC));
            Usuario A = new Usuario(Nombre, id, String.valueOf(numC));
            Cuentas_corrientes.add(C);
            Usuarios_Corriente.add(A);
            return String.valueOf(numC);
        }
        if (tipo.equals("Ahorros") || tipo.equals("ahorros") || tipo.equals("AHORROS") || tipo.equals("ahorro") || tipo.equals("Ahorro") || tipo.equals("AHORRO")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta_Ahorros C = new Cuenta_Ahorros(pin, saldo, String.valueOf(numC));
            Usuario B = new Usuario(Nombre, id, String.valueOf(numC));
            Cuentas_ahorros.add(C);
            Usuarios_Ahorro.add(B);
            return String.valueOf(numC);
        } else {
            return ("Imposible de crear cuenta con dichos parametros");
        }
    }
    
    /**
     * 
     * @param Numcuenta: Numero de cuenta generado aleatoriamente por el sistema
     * @param pin: Pin de la cuenta
     * @param tipo: Tipo de cuenta
     * @return Saldo: Retorna el Saldo actual de la cuenta
     */
    public float RetornarSaldo(String Numcuenta, String pin, String tipo){
        boolean Confirmacion = false;
        if (tipo.equals("Corriente") || tipo.equals("corriente") || tipo.equals("CORRIENTE")){
            for (Cuenta cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    Confirmacion = true;
                    return cuenta.getSaldo();
                }
            }
            if (Confirmacion == false){
                JOptionPane.showMessageDialog(null, "Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (tipo.equals("Ahorros") || tipo.equals("ahorros") || tipo.equals("AHORROS") || tipo.equals("ahorro") || tipo.equals("Ahorro") || tipo.equals("AHORRO")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    Confirmacion = true;
                    return cuenta.getSaldo();
                }
            }
            if (Confirmacion == false){
                JOptionPane.showMessageDialog(null, "Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
            }
        }
        return 404;
    }
    /**
     * 
     * @param Numcuenta: Numero de cuenta generado aleatoriamente por el sistema
     * @param pin: Pin de la cuenta
     * @param tipo: Tipo de cuenta
     * @param Cantidad: Cantidad que el usuario desea consignar a su cuenta
     * @return boolean: Retorna verdadero si la consignacion fue exitosa y falso si esta fue fallida
     */
    public boolean Consignacion(String Numcuenta, String pin, String tipo, float Cantidad){
        boolean Confirmacion = false;
        if (tipo.equals("Corriente") || tipo.equals("corriente") || tipo.equals("CORRIENTE")){
            for (Cuenta cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    cuenta.setSaldo(cuenta.getSaldo()+Cantidad);
                    Confirmacion = true;
                    return true;
                }
            }
            if (Confirmacion == false){
                JOptionPane.showMessageDialog(null, "Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else if (tipo.equals("Ahorros") || tipo.equals("ahorros") || tipo.equals("AHORROS") || tipo.equals("ahorro") || tipo.equals("Ahorro") || tipo.equals("AHORRO")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    cuenta.setSaldo(cuenta.getSaldo()+Cantidad);
                    Confirmacion = true;
                    return true;
                }
            }
            if (Confirmacion == false){
                JOptionPane.showMessageDialog(null, "Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param Numcuenta: Numero de cuenta generado aleatoriamente por el sistema
     * @param pin: Pin de la cuenta
     * @param tipo: Tipo de cuenta
     * @param Cantidad: Cantidad que el usuario desea retirar de su cuenta
     * @return boolean: Retorna verdadero si el retiro fue exitoso y falso si este fue fallido
     */
    public boolean Retirar(String Numcuenta, String pin, String tipo, float Cantidad){
        boolean Confirmacion = false;
        if(tipo.equals("Corriente") || tipo.equals("corriente") || tipo.equals("CORRIENTE")){
            for (Cuenta_Corriente cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    if (Cantidad <= cuenta.getSaldo()){
                            cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                            Confirmacion = true;
                            return true;
                        }
                    if (cuenta.getSaldo() > 0){
                        if ((cuenta.getCredito()+cuenta.getSaldo()) > (Cantidad)){
                            cuenta.setCredito((cuenta.getCredito()+cuenta.getSaldo())-Cantidad);
                            cuenta.setSaldo(-1*(300000-cuenta.getCredito()));
                            JOptionPane.showMessageDialog(null, "Crédito restante: "+cuenta.getCredito(), "Crédito", JOptionPane.INFORMATION_MESSAGE);
                            Confirmacion = true;
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Crédito Insuficiente", "Crédito", JOptionPane.ERROR_MESSAGE);  
                            return false;
                        }
                    } else {
                      if(cuenta.getCredito()>= Cantidad){
                            cuenta.setCredito(cuenta.getCredito()-Cantidad);
                            cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                            JOptionPane.showMessageDialog(null, "Crédito restante: "+cuenta.getCredito(), "Crédito", JOptionPane.INFORMATION_MESSAGE);
                            Confirmacion = true;
                            return true;
                      }else{
                            JOptionPane.showMessageDialog(null, "Crédito Insuficiente", "Crédito", JOptionPane.ERROR_MESSAGE);  
                            return false;
                      }  
                    }
                }
            }
            if (Confirmacion == false){
                JOptionPane.showMessageDialog(null, "Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return false;
        }
        else if (tipo.equals("Ahorros") || tipo.equals("ahorros") || tipo.equals("AHORROS") || tipo.equals("ahorro") || tipo.equals("Ahorro") || tipo.equals("AHORRO")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    if(Cantidad <= cuenta.getSaldo()){
                        cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                        Confirmacion = true;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo Insuficiente", "Saldo", JOptionPane.ERROR_MESSAGE);  
                        return false;
                    }
                }
            }
            if (Confirmacion == false){
                JOptionPane.showMessageDialog(null, "Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de cuenta Inexistente", "Cuenta", JOptionPane.ERROR_MESSAGE);  
            return false;
        }
        return false;
    }
    
    /**
     * 
     * @return 
     */
    public LinkedList<Usuario> getUsuarios_Corriente() {
        return Usuarios_Corriente;
    }
    
    /**
     * 
     * @param Usuarios_Corriente 
     */
    public void setUsuarios_Corriente(LinkedList<Usuario> Usuarios_Corriente) {
        this.Usuarios_Corriente = Usuarios_Corriente;
    }

    /**
     * 
     * @return 
     */
    public LinkedList<Usuario> getUsuarios_Ahorro() {
        return Usuarios_Ahorro;
    }

    /**
     * 
     * @param Usuarios_Ahorro 
     */
    public void setUsuarios_Ahorro(LinkedList<Usuario> Usuarios_Ahorro) {
        this.Usuarios_Ahorro = Usuarios_Ahorro;
    }
}
