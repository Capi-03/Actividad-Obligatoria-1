package ar.org.cfp8.java.sistemabancario.clientes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ClienteIndividual extends Cliente{

    private String nombre;
    private String apellido;
    private String dni;

    public ClienteIndividual(int numeroCliente, String nombre, String apellido, String dni){
        super(numeroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("===== CLIENTE INDIVIDUAL =====");
        System.out.println("Número de Cliente: " + getNumeroCliente());
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
    }

}