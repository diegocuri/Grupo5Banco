/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.entidades;

/**
 *
 * @author Usuario
 */
public class Pedido {
    
    private int num_pedido;
    private Prestamo prestamo;
    private Cliente cliente;
    private Inspector inspector;

    public Pedido() {
    }

    public Pedido(int num_pedido, Prestamo prestamo, Cliente cliente, Inspector inspector) {
        this.num_pedido = num_pedido;
        this.prestamo = prestamo;
        this.cliente = cliente;
        this.inspector = inspector;
    }

    public int getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(int num_pedido) {
        this.num_pedido = num_pedido;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }
    
    
    
    
    
}
