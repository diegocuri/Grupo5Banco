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
public class Inspector {
    private int codIs;
    private String nombre;
    private String apellido;
    private String direccion;
    private String titulo;

    public Inspector() {
    }

    public Inspector(int codIs, String nombre, String apellido, String direccion, String titulo) {
        this.codIs = codIs;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.titulo = titulo;
    }

    public int getCodIs() {
        return codIs;
    }

    public void setCodIs(int codIs) {
        this.codIs = codIs;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
