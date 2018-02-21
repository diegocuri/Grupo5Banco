
package grupo5banco.rnegocio.entidades;


public class Sucursal {
        private int codSu;
    private String ciudad;

    public Sucursal() {
    }

    public Sucursal(int codSu, String ciudad) {
        this.codSu = codSu;
        this.ciudad = ciudad;
    }

    public int getCodSu() {
        return codSu;
    }

    public void setCodSu(int codSu) {
        this.codSu = codSu;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
