/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebacuenta;

public class CuentaCorriente extends Cuenta {
    float sobregiro;
    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa); // Invoca al constructor de la clase padre
        sobregiro = 0; // Inicialmente no hay sobregiro
    }
    public void retirar(float cantidad) {
        float resultado = saldo - cantidad; // Se calcula un saldo temporal
        if (resultado < 0) {
            sobregiro = sobregiro - resultado;
            saldo = 0;
        } else {
            super.retirar(cantidad); /* Si no hay sobregiro, se realiza un retiro normal */
        }
    }
    public void consignar(float cantidad) {
        float residuo = sobregiro - cantidad;
        // Si existe sobregiro la cantidad consignada se resta al sobregiro
        if (sobregiro > 0) {
            if ( residuo > 0) { /* Si el residuo es mayor que cero, se libera el sobregiro */
                sobregiro = 0;
                saldo = residuo;
            } else { /* Si el residuo es menor que cero, el saldo es cero y surge un sobregiro */ 
                sobregiro = -residuo;
                saldo = 0;
            }
        } else {
            super.consignar(cantidad); /* Si no hay sobregiro, se realiza una consignación normal */
        }
    }
    public void extractoMensual() {
        super.extractoMensual(); // Invoca al método de la clase padre
    }  
    public void imprimir() {
        System.out.println("Saldo = $ " + saldo);
        System.out.println("Cargo mensual = $ " + comisionMensual);
        System.out.println("Numero de transacciones = " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Valor de sogregiro = $" + (numeroConsignaciones + numeroRetiros));
        System.out.println();
    }
}