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

    public Cuenta_Corriente(float Credito, String Pin, float Saldo) {
        super(Pin, Saldo);
        this.Credito = Credito;
    }
    
    @Override
    public boolean ConsignarCantidad(float Cantidad) {
        this.setSaldo(Cantidad + this.getSaldo());
        return true;
    }
    @Override
    public boolean RetirarCantidad(float Cantidad) {
        if ((this.getCredito()+this.getSaldo()) > (-300000+Cantidad)){
                if (Cantidad > this.getSaldo() && (this.getCredito()+this.getSaldo()) > Cantidad){
                if (this.getSaldo() > 0){
                    Cantidad = Cantidad - this.getSaldo();
                    this.setSaldo(0);
                }
                if ((this.getCredito()+this.getSaldo()) > Cantidad){
                    Cantidad =-300000 + (this.getCredito()-Cantidad);
                    this.setSaldo(Cantidad);
                    return true;
                } else {
                    return false;
                }
            }
            else if (Cantidad <= this.getSaldo()){
                this.setSaldo(this.getSaldo()-Cantidad);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public float getCredito() {
        return Credito;
    }

    public void setCredito(float Credito) {
        this.Credito = Credito;
    }
    
    
}
