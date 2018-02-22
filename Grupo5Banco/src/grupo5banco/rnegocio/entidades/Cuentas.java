/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.entidades;

/**
 *
 * @author stian
 */
public class Cuentas {
    
private int numerodecuenta;
private Cliente cliente;

    public Cuentas() {
    }

    public Cuentas(int numerodecuenta, Cliente cliente) {
        this.numerodecuenta = numerodecuenta;
        this.cliente = cliente;
    }

    public int getNumerodecuenta() {
        return numerodecuenta;
    }

    public void setNumerodecuenta(int numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}

