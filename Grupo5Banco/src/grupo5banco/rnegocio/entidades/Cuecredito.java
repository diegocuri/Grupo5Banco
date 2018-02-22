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
public class Cuecredito {
    private int n_cuenta;
    private Cuentas cuenta;
    private int saldo;
    private int u_sobregiro;

    public Cuecredito() {
    }

    public Cuecredito(int n_cuenta, Cuentas cuenta, int saldo, int u_sobregiro) {
        this.n_cuenta = n_cuenta;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.u_sobregiro = u_sobregiro;
    }
 public int getN_cuenta() {
        return n_cuenta;
    }

    public void setN_cuenta(int n_cuenta) {
        this.n_cuenta = n_cuenta;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getU_sobregiro() {
        return u_sobregiro;
    }

    public void setU_sobregiro(int u_sobregiro) {
        this.u_sobregiro = u_sobregiro;
    }

}

