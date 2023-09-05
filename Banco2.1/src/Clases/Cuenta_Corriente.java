package Clases;

/**
 *
 * @author Daniel Ramirez
 * @author Santiago Jimenez
 * @version 20230903
 * 
 */
public class Cuenta_Corriente extends Cuenta{
    private float Credito;

    /**
     * 
     * @param Credito: Credito otorgado por el banco
     * @param Pin: Pin de la cuenta
     * @param Saldo: Fondos de la cuenta
     * @param numCuenta: Numero de la cuenta 
     */
    public Cuenta_Corriente(float Credito, String Pin, float Saldo, String numCuenta) {
        super(Pin, Saldo, numCuenta);
        this.Credito = Credito;
    }
    /**
     * Getter
     * @return Credito: Credito otorgado por el banco 
     */
    public float getCredito() {
        return Credito;
    }
    /**
     * 
     * @param Credito 
     */
    public void setCredito(float Credito) {
        this.Credito = Credito;
    }
    
    
}
