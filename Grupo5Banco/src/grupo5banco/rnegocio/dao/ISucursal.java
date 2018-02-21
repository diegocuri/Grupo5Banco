
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Sucursal;
import java.util.List;

public interface ISucursal {
     int insertar(Sucursal sucursal) throws Exception;
    
    int modificar(Sucursal sucursal) throws Exception;
    
    int eliminar(Sucursal sucursal) throws Exception;
    
    Sucursal obtener(int codSu) throws Exception;
    
    List<Sucursal> obtener() throws Exception;
}
