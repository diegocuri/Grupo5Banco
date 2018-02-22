/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Inspector;
import java.util.List;

public interface IInspector {
     int insertar(Inspector empleado) throws Exception;
    int modificar(Inspector empleado) throws Exception;
    int eliminar(Inspector empleado) throws Exception;
    Inspector obtener(int codIs) throws Exception;
    List<Inspector> obtener() throws Exception;
    
    
}
