/*
 * 
 * 
 */
package Clases;

/**
 *
 * @author Daniel
 */
public class Cuenta_Ahorros extends Cuenta{

    public Cuenta_Ahorros(String Pin, float Saldo, String numCuenta) {
        super(null, 0, null);
    }

    

    
    

    

    
    public void setPin(String Pin) {
        super.setPin(Pin);
    }

    @Override
    public void setSaldo(float Saldo) {
        super.setSaldo(Saldo);
    }

    @Override
    public String getPin() {
        return super.getPin();
    }

    @Override
    public float getSaldo() {
        return super.getSaldo();
    }
    
}
