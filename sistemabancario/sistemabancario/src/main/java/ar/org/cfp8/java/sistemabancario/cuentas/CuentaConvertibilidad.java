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

    public void depositarDolares(double monto) {
        if (monto > 0) {
            saldoDolares += monto;
            System.out.println("Deposito de USD " + monto + " realizado. Nuevo saldo USD: " + saldoDolares);
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
        if (montoPesos > 0 && montoPesos <= getSaldo()) {
            double dolares = montoPesos / tasaConversion;
            extraer(montoPesos);
            saldoDolares += dolares;
            System.out.println("Convertidos $" + montoPesos + " a USD " + dolares + " (tasa: " + tasaConversion + ")");
        } else {
            System.out.println("Conversion fallida. Saldo insuficiente en pesos.");
        }
    }

    public void convertirDolaresAPesos(double montoDolares, double tasaConversion) {
        if (montoDolares > 0 && montoDolares <= saldoDolares) {
            double pesos = montoDolares * tasaConversion;
            saldoDolares -= montoDolares;
            depositar(pesos);
            System.out.println("Convertidos USD " + montoDolares + " a $" + pesos + " (tasa: " + tasaConversion + ")");
        } else {
            System.out.println("Conversion fallida. Saldo insuficiente en dolares.");
        }
    }
}