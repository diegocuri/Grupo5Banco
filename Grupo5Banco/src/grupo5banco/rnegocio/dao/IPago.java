/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Pago;
import java.util.List;

public interface IPago {
     int insertar(Pago pago) throws Exception;
    int modificar(Pago pago) throws Exception;
    int eliminar(Pago pago) throws Exception;
    Pago obtener(int cod_pago) throws Exception;
    List<Pago> obtener() throws Exception;
    
    
}