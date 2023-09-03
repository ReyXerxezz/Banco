/*
 * 
 *
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class Cuenta {
    private String Pin;
    private float Saldo;

    public Cuenta(String Pin, float Saldo) {
        this.Pin = Pin;
        this.Saldo = Saldo;
    }
    
    
    
    public float ConsultarCantidad (){
        return getSaldo();
    }
    public boolean RetirarCantidad (float Cantidad){
        return false;
    }
    public boolean ConsignarCantidad (float Cantidad){
        return false;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }
}
