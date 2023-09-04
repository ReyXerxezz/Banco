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
    private float Saldo;private String numCuenta;

    public Cuenta(String Pin, float Saldo, String numCuenta) {
        this.Pin = Pin;
        this.Saldo = Saldo;
        this.numCuenta = numCuenta;
    }
    public boolean RetirarCantidad (float Cantidad){
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

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
}
