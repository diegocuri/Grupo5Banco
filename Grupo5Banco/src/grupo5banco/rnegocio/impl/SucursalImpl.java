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
    public int insertar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into sucursal values(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCodSu()));
        lstPar.add(new Parametro(2, sucursal.getCiudad()));
        
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
        
    }

    @Override
    public int modificar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update sucursal set ciudad= '"+sucursal.getCiudad()
                + "' where  codSu = " + sucursal.getCodSu();
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCiudad()));
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
        
    }

    @Override
    public int eliminar(Sucursal sucursal) throws Exception {
int numFilasAfectadas = 0;
        String sql = "delete from sucursal WHERE codSu=" + sucursal.getCodSu();
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;    }

    @Override
    public Sucursal obtener(int codSu) throws Exception {
   Sucursal sucursal = null;
        String sql = "select codSu, ciudad from sucursal where codSu=?";
        Conexion con = new Conexion();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, codSu));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                sucursal=new Sucursal();
                sucursal.setCodSu(rst.getInt(1));
                sucursal.setCiudad(rst.getString(2));               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return sucursal;    }

    @Override
    public List<Sucursal> obtener() throws Exception {
         List<Sucursal> lista = new ArrayList<>();
        
        String sql = "select codSu, ciudad from sucursal";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setCodSu(rst.getInt(1));
                sucursal.setCiudad(rst.getString(2));
                lista.add(sucursal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
    
}
