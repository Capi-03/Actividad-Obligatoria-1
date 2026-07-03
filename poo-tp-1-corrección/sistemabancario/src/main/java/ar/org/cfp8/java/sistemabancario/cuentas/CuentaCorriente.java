package ar.org.cfp8.java.sistemabancario.cuentas;

import ar.org.cfp8.java.sistemabancario.cheques.Cheque;
import ar.org.cfp8.java.sistemabancario.clientes.Cliente;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta {

    @Setter
    private double montoAutorizadoDescubierto;

    public CuentaCorriente(String numeroCuenta, Cliente cliente, double saldoInicial, double montoAutorizadoDescubierto) {
        super(numeroCuenta, cliente, saldoInicial);
        this.montoAutorizadoDescubierto = montoAutorizadoDescubierto;
    }

    public void depositarCheque(Cheque cheque) {
        if (cheque != null) {
            depositar(cheque.getMonto());
            System.out.println("Cheque depositado: " + cheque);
        } else {
            System.out.println("No se pudo depositar el cheque.");
        }
    }

    @Override
    public boolean extraer(double monto) {
        double saldoDisponible = saldo + montoAutorizadoDescubierto;
        if (monto > 0 && monto <= saldoDisponible) {
            saldo -= monto;
            System.out.println("Extraccion de $" + monto + " realizada (utilizando descubierto si fue necesario). Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Extraccion fallida. Monto excede saldo disponible");
            return false;
        }
    }
}