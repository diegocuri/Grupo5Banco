
package grupo5banco.rnegocio.entidades;


public class Cliente {
    private int codCl;
    private Sucursal sucursal;
    private String cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;

    public Cliente() {
    }

    public Cliente(int codCl, Sucursal sucursal, String cedula, String nombre, String apellido, String celular, String email) {
        this.codCl = codCl;
        this.sucursal = sucursal;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }

    public int getCodCl() {
        return codCl;
    }

    public void setCodCl(int codCl) {
        this.codCl = codCl;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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