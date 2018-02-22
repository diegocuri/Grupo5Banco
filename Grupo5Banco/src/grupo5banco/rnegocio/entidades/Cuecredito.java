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
     private int codigocc ;
    private double Valorsobregiro;

    public Cuecredito(int codigocc, double Valorsobregiro) {
        this.codigocc = codigocc;
        this.Valorsobregiro = Valorsobregiro;
    }

    public Cuecredito() {
    }

    public int getCodigocc() {
        return codigocc;
    }

    public void setCodigocc(int codigocc) {
        this.codigocc = codigocc;
    }

    public double getValorsobregiro() {
        return Valorsobregiro;
    }

    public void setValorsobregiro(double Valorsobregiro) {
        this.Valorsobregiro = Valorsobregiro;
    }
}

