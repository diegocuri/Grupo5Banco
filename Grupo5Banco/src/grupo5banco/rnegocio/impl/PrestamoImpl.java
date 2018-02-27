/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.impl;


import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTHONY
 */
public class PrestamoImpl implements IPrestamo {

    @Override
    public int insertar(Prestamo prestamo) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "INSERT INTO prestamo(\n"
                + "            codPre_prestamo, codSu_sucrusal, )\n"
                + "    VALUES (?, ?,);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getCodPre()));
        lstPar.add(new Parametro(2, prestamo.getSucursal().getCodSu()));
        

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
    public int modificar(Prestamo prestamo) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "UPDATE prestamo\n"
                + "   SET codPre_prestamo=? ,CodSu=?, \n"
                + " WHERE codPre_prestamo=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getCodPre()));
        lstPar.add(new Parametro(2, prestamo.getSucursal().getCodSu()));
       

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
    public int eliminar(Prestamo prestamo) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "DELETE FROM   Prestamo\n"
                + " WHERE codPre=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getCodPre()));
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql,lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public Prestamo obtener(int CodPre) throws Exception {
        Prestamo prestamo = null;
        String sql = "SELECT codPre ,codSu, \n"
                + "  FROM prestamo where codPre=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodPre));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                prestamo = new Prestamo();
                prestamo.setCodPre(rst.getInt(1));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return prestamo;
    }

    @Override
    public List<Prestamo> obtener() throws Exception {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT codPre ,codSu \n"
                + "  FROM prestamo";
        Conexion con = new Conexion();
        con.conectar();
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Prestamo prestamo=null;
            while (rst.next()) {
                prestamo = new Prestamo();
                prestamo.setCodPre(rst.getInt(1));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
                lista.add(prestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
}

    
    
