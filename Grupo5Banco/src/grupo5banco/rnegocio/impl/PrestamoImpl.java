/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.impl;


import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.IPrestamo;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Prestamo;
import grupo5banco.rnegocio.entidades.Sucursal;
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
        String sql = "INSERT INTO prestamo VALUES (?, ?)";
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
        String sql = "UPDATE prestamo"
                + "   SET CodPre=?, codSu=?"
                + " WHERE CodPre=?";
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
        String sql = "DELETE FROM prestamo"
                + " WHERE CodPre=?";
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
        String sql = "SELECT CodPre, codSu FROM prestamo where CodPre=?";
       Conexion con=new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodPre));
        con.conectar();
        try {
            
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                prestamo = new Prestamo();
                prestamo.setCodPre(rst.getInt(1));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
                prestamo.setSucursal(sucursal);
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
        String sql = "SELECT CodPre ,codSu"
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
                prestamo.setSucursal(sucursal);
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

    
    
