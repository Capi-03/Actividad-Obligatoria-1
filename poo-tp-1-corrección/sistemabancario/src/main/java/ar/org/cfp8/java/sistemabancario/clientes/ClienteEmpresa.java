package ar.org.cfp8.java.sistemabancario.clientes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ClienteEmpresa extends Cliente{

    @Setter  
    private String nombreFantasia;

    private String cuit;

    public ClienteEmpresa(int numeroCliente, String nombreFantasia, String cuit){
        super(numeroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("===== CLIENTE EMPRESA =====");
        System.out.println("Número de Cliente: " + getNumeroCliente());
        System.out.println("Nombre Fantasía: " + getNombreFantasia());
        System.out.println("CUIT: " + getCuit());
    }

}