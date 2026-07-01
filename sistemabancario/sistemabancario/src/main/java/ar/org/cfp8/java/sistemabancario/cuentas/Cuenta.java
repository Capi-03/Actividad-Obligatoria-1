package ar.org.cfp8.java.sistemabancario.cuentas;

import ar.org.cfp8.java.sistemabancario.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Cuenta {
    private final String numeroCuenta;
    private final Cliente cliente;
    protected double saldo;

    public Cuenta(String numeroCuenta, Cliente cliente, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito de $" + monto + " realizado. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("El monto debe ser positivo.");
        }
    }

    public abstract boolean extraer(double monto);
}