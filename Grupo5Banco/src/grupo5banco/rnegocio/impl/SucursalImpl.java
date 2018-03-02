/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.impl;

import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SucursalImpl implements ISucursal {

    @Override
    public int insertar(Sucursal sucursales) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into sucursales values(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursales.getCodSu()));
        lstPar.add(new Parametro(2, sucursales.getCiudad()));
    
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Sucursal sucursales) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  sucursales set CodSu=?, ciudad=? where CodSu=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursales.getCodSu()));
        lstPar.add(new Parametro(2, sucursales.getCiudad()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Sucursal sucursales) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM sucursales  where CodSu=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursales.getCodSu()));
              
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        
        return numFilasAfectadas;
    }

    @Override
    public Sucursal obtener(int idSucursal) throws Exception {
        Sucursal sucursales = null;
         String sql = "select CodSu, ciudad from sucursales where CodSu=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idSucursal));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                sucursales= new Sucursal();
                sucursales.setCodSu(rst.getInt(1));
                sucursales.setCiudad(rst.getString(2));            
             
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return sucursales;
    }

    @Override
    public List<Sucursal> obtener() throws Exception {
        List<Sucursal> lista = new ArrayList<>();
         String sql = "select CodSu, ciudad from sucursales";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Sucursal sucursales= null;
            while(rst.next()){
                sucursales= new Sucursal();
                sucursales.setCodSu(rst.getInt(1));
                sucursales.setCiudad(rst.getString(2));            
        
                lista.add(sucursales);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
