/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.entidades;
import java.util.*;
public class Empleado {

    private int codEpl;
    private Sucursal sucursal;
    private String nombre;
    private String apellido;
    private Date fecha_vinculacion;
    private int antiguedad ; 

    public Empleado() {
    }

    public Empleado(int codEpl, Sucursal sucursal, String nombre, String apellido, Date fecha_vinculacion, int antiguedad) {
        this.codEpl = codEpl;
        this.sucursal = sucursal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_vinculacion = fecha_vinculacion;
        this.antiguedad = antiguedad;
    }

    public int getCodEpl() {
        return codEpl;
    }

    public void setCodEpl(int codEpl) {
        this.codEpl = codEpl;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_vinculacion() {
        return fecha_vinculacion;
    }

    public void setFecha_vinculacion(Date fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    
}

