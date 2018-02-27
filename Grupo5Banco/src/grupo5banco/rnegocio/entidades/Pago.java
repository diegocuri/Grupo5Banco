
package grupo5banco.rnegocio.entidades;

import java.util.Date;


public class Pago {
    private int cod_pago;
    private Prestamo prestamo;
    private Date fecha_pago;
    private String valor;

    public Pago() {
    }

    public Pago(int cod_pago, Prestamo prestamo, Date fecha_pago, String valor) {
        this.cod_pago = cod_pago;
        this.prestamo = prestamo;
        this.fecha_pago = fecha_pago;
        this.valor = valor;
    }

    public int getCod_pago() {
        return cod_pago;
    }

    public void setCod_pago(int cod_pago) {
        this.cod_pago = cod_pago;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}
