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
public class Cueahorros {
    private int codigoca;
    private double interes;

    public Cueahorros(int codigoca, double interes) {
        this.codigoca = codigoca;
        this.interes = interes;
    }

    public Cueahorros() {
    }

    public int getCodigoca() {
        return codigoca;
    }

    public void setCodigoca(int codigoca) {
        this.codigoca = codigoca;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
}
