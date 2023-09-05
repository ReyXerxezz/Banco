package Clases;

/**
 *
 * @author Daniel Ramirez
 * @author Santiago Jimenez
 * @version 20230903
 * 
 */
public class Cuenta_Ahorros extends Cuenta{
    
    /**
     * 
     * @param Pin: Pin de la cuenta
     * @param Saldo: Fondos de la cuenta
     * @param numCuenta: Numero de la cuenta 
     */
    public Cuenta_Ahorros(String Pin, float Saldo, String numCuenta) {
        super(Pin, Saldo, numCuenta);
    }
    
}
