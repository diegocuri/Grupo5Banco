/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.dao;

import grupo5banco.rnegocio.entidades.*;
import java.util.*;

/**
 *
 * @author stian
 */
public interface ICu_Ahorro {
      public int insertar(Cueahorros cueahorro) throws Exception;
    public int modificar(Cueahorros cueahorro) throws Exception;
    public int eliminar(Cueahorros cueahorro) throws Exception;
    public Cueahorros obtener(int codigo) throws Exception;
    public List<Cueahorros> obtener() throws Exception;  
}
