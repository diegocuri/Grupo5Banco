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
public class Cliente {
    private int CodCL;
    private String cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;

    public Cliente() {
    }

    public Cliente(int CodCL, String cedula, String nombre, String apellido, String celular, String email) {
        this.CodCL = CodCL;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }

    public int getCodCL() {
        return CodCL;
    }

    public void setCodCL(int CodCL) {
        this.CodCL = CodCL;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
          
}
