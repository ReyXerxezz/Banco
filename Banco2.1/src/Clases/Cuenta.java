package Clases;

/**
 *
 * @author Daniel Ramirez
 * @author Santiago Jimenez
 * @version 20230903
 * 
 */
public class Cuenta {
    private String Pin;
    private float Saldo;
    private String numCuenta;

    /**
     * 
     * @param Pin: Pin de la cuenta
     * @param Saldo: Fondos de la cuenta
     * @param numCuenta: Numero de la cuenta 
     */
    public Cuenta(String Pin, float Saldo, String numCuenta) {
        this.Pin = Pin;
        this.Saldo = Saldo;
        this.numCuenta = numCuenta;
    }
    /**
     * Getter
     * @return Pin: Pin de la cuenta 
     */
    public String getPin() {
        return Pin;
    }
    /**
     * Setter
     * @param Pin 
     */
    public void setPin(String Pin) {
        this.Pin = Pin;
    }
    /**
     * Getter
     * @return Saldo: Fondos de la cuenta 
     */
    public float getSaldo() {
        return Saldo;
    }
    /**
     * Setter
     * @param Saldo 
     */
    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }
    /**
     * Getter
     * @return NumCuenta: Numero de la cuenta 
     */
    public String getNumCuenta() {
        return numCuenta;
    }
    /**
     * Setter
     * @param numCuenta 
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
}
