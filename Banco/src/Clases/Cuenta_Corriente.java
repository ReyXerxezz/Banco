/*
 * 
 * 
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class Cuenta_Corriente extends Cuenta{
    private float Credito;

    public Cuenta_Corriente(float Credito, String Pin, float Saldo, String numCuenta) {
        super(Pin, Saldo, numCuenta);
        this.Credito = Credito;
    }
    public float getCredito() {
        return Credito;
    }

    public void setCredito(float Credito) {
        this.Credito = Credito;
    }
    
    
}
