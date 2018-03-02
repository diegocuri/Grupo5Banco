
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Cliente;
import java.util.List;


public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    Cliente obtener(int codCl) throws Exception;
    List<Cliente> obtener() throws Exception;
}
