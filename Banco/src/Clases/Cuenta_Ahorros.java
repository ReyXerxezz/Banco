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

    

    @Override
    public boolean ConsignarCantidad(float Cantidad) {
        if (Cantidad > 10000){
            this.setSaldo(getSaldo() + Cantidad);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean RetirarCantidad(float Cantidad) {
        float Saldo_actual = this.getSaldo();
        if(Cantidad <= this.getSaldo()){
            this.setSaldo(Saldo_actual-Cantidad);
            return true;
        } else {
            return false;
        }
    }

    

    @Override
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
