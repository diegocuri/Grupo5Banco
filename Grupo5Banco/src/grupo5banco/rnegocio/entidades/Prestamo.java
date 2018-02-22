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
public class Prestamo {
    private int CodPre;
    private Sucursal sucursal;

    public Prestamo() {
    }

    public Prestamo(int CodPre, Sucursal sucursal) {
        this.CodPre = CodPre;
        this.sucursal = sucursal;
    }

    public int getCodPre() {
        return CodPre;
    }

    public void setCodPre(int CodPre) {
        this.CodPre = CodPre;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
}
