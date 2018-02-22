/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.Prestamo;
import java.util.List;


public interface IPrestamo {
    public int insertar(Prestamo prestamo) throws Exception;
    public int modificar(Prestamo prestamo) throws Exception;
    public int eliminar(Prestamo prestamo) throws Exception;
    public Prestamo obtener(int codigo) throws Exception;
    public List<Prestamo> obtener() throws Exception; 
}
