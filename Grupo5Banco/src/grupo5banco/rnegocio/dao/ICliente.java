
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Cliente;
import java.util.List;


public interface ICliente {
    int insertar(Cliente cliente) throws Exception;
    int modificar(Cliente cliente) throws Exception;
    int eliminar(Cliente cliente) throws Exception;
    Cliente obtener(int CodCL) throws Exception;
    List<Cliente> obtener() throws Exception;
}
