/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;
import grupo5banco.rnegocio.entidades.*;
import java.util.*;
public interface ICu_Credito {
    public int insertar(Cuecredito cueacredito) throws Exception;
    public int modificar(Cuecredito cueacredito) throws Exception;
    public int eliminar(Cuecredito cueacredito) throws Exception;
    public Pedido obtener(int codigo) throws Exception;
    public List<Cuecredito> obtener() throws Exception;  
}
