package ar.org.cfp8.java.sistemabancario.cuentas;

import ar.org.cfp8.java.sistemabancario.cheques.Cheque;
import ar.org.cfp8.java.sistemabancario.clientes.Cliente;
import lombok.ToString;
import lombok.Getter;

@Getter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta {

    private final double montoAutorizadoDescubierto;

    public CuentaCorriente(String numeroCuenta, Cliente cliente, double saldoInicial, double montoAutorizadoDescubierto) {
        super(numeroCuenta, cliente, saldoInicial);
        this.montoAutorizadoDescubierto = montoAutorizadoDescubierto;
    }

    public void depositarCheque(Cheque cheque) {
        if (cheque != null) {
            depositar(cheque.getMonto());
            System.out.println("Cheque depositado: " + cheque);
        }
    }

    @Override
    public boolean extraer(double monto) {
        double saldoDisponible = saldo + montoAutorizadoDescubierto;
        if (monto > 0 && monto <= saldoDisponible) {
            saldo -= monto;
            System.out.println("Extraccion de $" + monto + " realizada (usando descubierto si necesario). Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Extraccion fallida. Monto excede saldo + descubierto.");
            return false;
        }
    }
}