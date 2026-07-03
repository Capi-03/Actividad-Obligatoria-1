package ar.org.cfp8.java.sistemabancario.cuentas;

import ar.org.cfp8.java.sistemabancario.clientes.ClienteEmpresa;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {

    private double saldoDolares;

    public CuentaConvertibilidad(String numeroCuenta, ClienteEmpresa cliente, double saldoPesosInicial, double montoAutorizadoDescubierto, double saldoDolaresInicial) {
        super(numeroCuenta, cliente, saldoPesosInicial, montoAutorizadoDescubierto);
        this.saldoDolares = saldoDolaresInicial;
    }

    public boolean depositarDolares(double monto) {
        if (monto > 0) {
            saldoDolares += monto;
            System.out.println("Deposito de USD " + monto + " realizado. Nuevo saldo USD: " + saldoDolares);
            return true;
        } else {
            System.out.println("No se pudo realizar el depósito. El monto debe ser mayor que cero.");
            return false;
        }
    }

    public boolean extraerDolares(double monto) {
        if (monto > 0 && monto <= saldoDolares) {
            saldoDolares -= monto;
            System.out.println("Extraccion de USD " + monto + " realizada. Nuevo saldo USD: " + saldoDolares);
            return true;
        } else {
            System.out.println("Extraccion USD fallida. Saldo insuficiente.");
            return false;
        }
    }

    public void convertirPesosADolares(double montoPesos, double tasaConversion) {

        if (montoPesos <= 0) {
            System.out.println("Conversión fallida. El monto en pesos debe ser mayor que cero.");
            return;
        }
        if (tasaConversion <= 0) {
            System.out.println("Conversión fallida. La tasa de conversión debe ser mayor que cero.");
            return;
        }
        if (montoPesos > getSaldo()) {
            System.out.println("Conversión fallida. Saldo insuficiente en pesos.");
            return;
        }
        double dolares = montoPesos / tasaConversion;
        extraer(montoPesos);
        saldoDolares += dolares;
        System.out.println("Conversión realizada: $" + montoPesos + " = USD " + dolares + " (Tasa: " + tasaConversion + ")");
    }

    public void convertirDolaresAPesos(double montoDolares, double tasaConversion) {

        if (montoDolares <= 0) {
            System.out.println("Conversión fallida. El monto en dólares debe ser mayor que cero.");
            return;
        }
        if (tasaConversion <= 0) {
            System.out.println("Conversión fallida. La tasa de conversión debe ser mayor que cero.");
            return;
        }
        if (montoDolares > saldoDolares) {
            System.out.println("Conversión fallida. Saldo insuficiente en dólares.");
            return;
        }
        double pesos = montoDolares * tasaConversion;
        saldoDolares -= montoDolares;
        depositar(pesos);
        System.out.println("Conversión realizada: USD " + montoDolares + " = $" + pesos + " (Tasa: " + tasaConversion + ")");
    }

}