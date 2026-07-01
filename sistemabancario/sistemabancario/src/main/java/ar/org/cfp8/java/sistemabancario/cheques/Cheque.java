package ar.org.cfp8.java.sistemabancario.cheques;

import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@ToString
public class Cheque {
    private final double monto;
    private final String bancoEmisor;
    private final LocalDate fechaPago;

    public Cheque(double monto, String bancoEmisor, LocalDate fechaPago) {
        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.fechaPago = fechaPago;
    }
}