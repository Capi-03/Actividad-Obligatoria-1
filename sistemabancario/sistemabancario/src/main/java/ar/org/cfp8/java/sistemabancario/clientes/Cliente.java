package ar.org.cfp8.java.sistemabancario.clientes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Cliente {

    private final int numeroCliente;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public abstract void mostrarDatos();

}
