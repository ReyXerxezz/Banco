/*
 * 
 * 
 */
package Clases;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Gestor_Banco {    
    private LinkedList<Usuario>Usuarios_Corriente = new LinkedList<>();
    private LinkedList<Usuario>Usuarios_Ahorro = new LinkedList<>();
    private LinkedList<Cuenta_Corriente> Cuentas_corrientes = new LinkedList<>();
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
            Cuenta_Corriente C = new Cuenta_Corriente(300000, pin, saldo, String.valueOf(numC));
            Usuario A = new Usuario(Nombre, id, String.valueOf(numC));
            Cuentas_corrientes.add(C);
            Usuarios_Corriente.add(A);
            return String.valueOf(numC);
        }
        if (tipo_cuenta.equals("Ahorros")){
            Random random = new Random();
            int numC = random.nextInt(900000000) + 100000000;
            Cuenta C = new Cuenta_Ahorros(pin, saldo, String.valueOf(numC));
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
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    return cuenta.getSaldo();
                }else{
                    JOptionPane.showMessageDialog(null, "   Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if (tipo.equals("Ahorros")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    return cuenta.getSaldo();
                }else{
                    JOptionPane.showMessageDialog(null, "   Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
        return 404;
    }
    public boolean Consignacion(String Numcuenta, String pin, String tipo, float Cantidad){
        if(tipo.equals("Corriente")){
            for (Cuenta cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    cuenta.setSaldo(cuenta.getSaldo()+Cantidad);
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "   Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        else if (tipo.equals("Ahorros")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    cuenta.setSaldo(cuenta.getSaldo()+Cantidad);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "   Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } 
            return false;
        
    }
    /*public float Consignar(String Numcuenta, String pin, String tipo, float cantidad){
        if(tipo.equals("Corriente")){
            for (Cuenta cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta())){
                    cuenta.setSaldo(cuenta.getSaldo()+cantidad);
                    JOptionPane.showMessageDialog(null, "Consignación exitosa", "CONSIGNACIÓN", JOptionPane.DEFAULT_OPTION);
                    return cuenta.getSaldo();
                }
            }
        }
        if (tipo.equals("Ahorros")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta())){
                    cuenta.setSaldo(cuenta.getSaldo()+cantidad);
                    JOptionPane.showMessageDialog(null, "Consignación exitosa", "CONSIGNACIÓN", JOptionPane.DEFAULT_OPTION);
                    return cuenta.getSaldo();
                }
            }
        } 
        return 0;
    }
*/
    public boolean Retirar(String Numcuenta, String pin, String tipo, float Cantidad){
        if(tipo.equals("Corriente")){
            for (Cuenta_Corriente cuenta : Cuentas_corrientes){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    if (Cantidad <= cuenta.getSaldo()){
                            cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                            return true;
                        }
                    if (cuenta.getSaldo() > 0){
                        if ((cuenta.getCredito()+cuenta.getSaldo()) > (Cantidad)){
                            cuenta.setCredito((cuenta.getCredito()+cuenta.getSaldo())-Cantidad);
                            cuenta.setSaldo(-1*(300000-cuenta.getCredito()));
                            JOptionPane.showMessageDialog(null, "Crédito restante: "+cuenta.getCredito(), "Crédito", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                        JOptionPane.showMessageDialog(null, "Crédito Insuficiente", "Crédito", JOptionPane.ERROR_MESSAGE);  
                        return false;
                        }
                    }else{
                      if(cuenta.getCredito()>= Cantidad){
                        cuenta.setCredito(cuenta.getCredito()-Cantidad);
                        cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                        JOptionPane.showMessageDialog(null, "Crédito restante: "+cuenta.getCredito(), "Crédito", JOptionPane.INFORMATION_MESSAGE);
                        return true;
                      }else{
                        JOptionPane.showMessageDialog(null, "Crédito Insuficiente", "Crédito", JOptionPane.ERROR_MESSAGE);  
                        return false;
                      }  
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "   Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                }
            }
            return false;
        }
        else if (tipo.equals("Ahorros")){
            for (Cuenta cuenta : Cuentas_ahorros){
                if(Numcuenta.equals(cuenta.getNumCuenta()) && pin.equals(cuenta.getPin())){
                    if(Cantidad <= cuenta.getSaldo()){
                        cuenta.setSaldo(cuenta.getSaldo()-Cantidad);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo Insuficiente", "Saldo", JOptionPane.ERROR_MESSAGE);  
                        return false;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "   Número de cuenta ó PIN incorrecto", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de cuenta Inexistente", "Cuenta", JOptionPane.ERROR_MESSAGE);  
            return false;
        }
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
