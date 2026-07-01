package ar.org.cfp8.java.sistemabancario.cuentas;

import ar.org.cfp8.java.sistemabancario.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CajaDeAhorro extends Cuenta {

    private final double tasaInteres;

    public CajaDeAhorro(String numeroCuenta, Cliente cliente, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, cliente, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public void cobrarInteres() {
        double interes = saldo * tasaInteres;
        saldo += interes;
        System.out.println("Intereses cobrados: $" + interes + ". Nuevo saldo: $" + saldo);
    }

    @Override
    public boolean extraer(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Extraccion de $" + monto + " realizada. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Extraccion fallida. Saldo insuficiente o monto invalido.");
            return false;
        }
    }
}