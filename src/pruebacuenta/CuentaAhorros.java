/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebacuenta;

public class CuentaAhorros extends Cuenta {
    private boolean activa;
    public CuentaAhorros(float saldo, float tasa) {
        super(saldo, tasa);
        if (saldo < 10000)  /* Si el saldo es menor a 10000, la cuenta no se activa */
            activa = false;
        else
            activa = true;
    }
    public void retirar(float cantidad) {
        if (activa) // Si la cuenta está activa, se puede retirar dinero
            super.retirar(cantidad); /* Invoca al método retirar de la clase padre */
    }
    public void consignar(float cantidad) {
        if (activa) // Si la cuenta está activa, se puede consignar dinero
            super.consignar(cantidad); /* Invoca al método consignar de la clase padre */
    }
    public void extractoMensual() {
        /* Si la cantidad de retiros es superior a cuatro, se genera una comisión mensual */
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual(); // Invoca al método de la clase padre 
        /* Si el saldo actualizado de la cuenta es menor a 10000, la cuenta no se activa */
        if ( saldo < 10000 )
            activa = false;
    }
    public void imprimir() {
        System.out.println("Saldo = $ " + saldo);
        System.out.println("Comision mensual = $ " + comisionMensual);
        System.out.println("Numero de transacciones = " + (numeroConsignaciones + numeroRetiros));
        System.out.println();
    }
}
