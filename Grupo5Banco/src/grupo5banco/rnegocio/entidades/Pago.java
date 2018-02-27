
package grupo5banco.rnegocio.entidades;

import java.util.Date;


public class Pago {
    private int cod_pago;
    private Prestamo prestamo;
    private Date fecha_pre;
    private String valor;

    public Pago() {
    }

    public Pago(int cod_pago, Prestamo prestamo, Date fecha_pre, String valor) {
        this.cod_pago = cod_pago;
        this.prestamo = prestamo;
        this.fecha_pre = fecha_pre;
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

    public Date getFecha_pre() {
        return fecha_pre;
    }

    public void setFecha_pre(Date fecha_pre) {
        this.fecha_pre = fecha_pre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
