package ar.org.cfp8.java.sistemabancario.tests;

import ar.org.cfp8.java.sistemabancario.cheques.Cheque;
import ar.org.cfp8.java.sistemabancario.clientes.*;
import ar.org.cfp8.java.sistemabancario.cuentas.CajaDeAhorro;
import ar.org.cfp8.java.sistemabancario.cuentas.CuentaConvertibilidad;
import ar.org.cfp8.java.sistemabancario.cuentas.CuentaCorriente;

import java.time.LocalDate;

public class TestSistemaBancario {
    public static void main(String[] args) {

        ClienteIndividual juan = new ClienteIndividual(1, "Juan", "Perez", "12345678");
        ClienteEmpresa empresa = new ClienteEmpresa(2, "Franchi's", "20-12345678-9");

        System.out.println("==================================");
        System.out.println("      DATOS DE LOS CLIENTES");
        System.out.println("==================================");

        juan.mostrarDatos();
        System.out.println();
        empresa.mostrarDatos();
        System.out.println();

        System.out.println("==================================");
        System.out.println("      CAJA DE AHORRO");
        System.out.println("==================================");

        CajaDeAhorro caja = new CajaDeAhorro("CA001", juan, 1000, 0.05);

        caja.depositar(500);
        caja.extraer(300);
        caja.cobrarInteres();

        System.out.println();
        System.out.println("==================================");
        System.out.println("      CUENTA CORRIENTE");
        System.out.println("==================================");

        CuentaCorriente corriente = new CuentaCorriente("CC001", juan, 2000, 1000);

        corriente.depositar(1000);

        Cheque cheque = new Cheque(500, "Banco Lihu", LocalDate.now().plusDays(5));

        corriente.depositarCheque(cheque);
        corriente.extraer(3500);

        System.out.println();
        System.out.println("==================================");
        System.out.println("   CUENTA CONVERTIBILIDAD");
        System.out.println("==================================");

        CuentaConvertibilidad convertibilidad = new CuentaConvertibilidad("CCV001", empresa, 5000, 2000, 1000);

        convertibilidad.depositar(2000);
        convertibilidad.depositarDolares(500);
        convertibilidad.extraerDolares(200);
        convertibilidad.convertirPesosADolares(1000, 1000);
        convertibilidad.convertirDolaresAPesos(300, 1050);

        System.out.println();
        System.out.println("==================================");
        System.out.println("   ESTADO FINAL DE LAS CUENTAS");
        System.out.println("==================================");

        System.out.println(caja);
        System.out.println();

        System.out.println(corriente);
        System.out.println();

        System.out.println(convertibilidad);
    }
}