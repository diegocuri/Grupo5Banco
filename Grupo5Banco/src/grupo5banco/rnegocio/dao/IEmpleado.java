/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Empleado;
import java.util.List;

public interface IEmpleado {
     int insertar(Empleado empleado) throws Exception;
    int modificar(Empleado empleado) throws Exception;
    int eliminar(Empleado empleado) throws Exception;
    Empleado obtener(int codEpl) throws Exception;
    List<Empleado> obtener() throws Exception;
    
    
}
