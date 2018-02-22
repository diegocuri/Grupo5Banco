/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.*;
import java.util.*;

public interface ICuentas {
      public int insertar(Cuentas cuenta) throws Exception;
    public int modificar(Cuentas cuenta) throws Exception;
    public int eliminar(Cuentas cuenta) throws Exception;
    public Pedido obtener(int codigo) throws Exception;
    public List<Cuentas> obtener() throws Exception;  
}
