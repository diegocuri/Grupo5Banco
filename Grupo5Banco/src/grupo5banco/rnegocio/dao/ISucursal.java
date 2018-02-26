package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Sucursal;
import java.util.List;

public interface ISucursal {

    public int insertar(Sucursal sucursal) throws Exception;

    public int modificar(Sucursal sucursal) throws Exception;

    public int eliminar(Sucursal sucursal) throws Exception;

    public Sucursal obtener(int codSu) throws Exception;

    public List<Sucursal> obtener() throws Exception;
}
