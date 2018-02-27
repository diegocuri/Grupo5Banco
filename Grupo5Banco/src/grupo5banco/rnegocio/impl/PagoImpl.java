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
public class PagoImpl implements IPago {

    @Override
    public int insertar(Pago pago) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "INSERT INTO pago(\n"
                + "            cod_pago, cod_pago,fecha,valor, )\n"
                + "    VALUES (?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCod_pago()));
        lstPar.add(new Parametro(2, pago.getPrestamo().getCodPre()));
        lstPar.add(new Parametro(3, pago.getFecha_pago()));
        lstPar.add(new Parametro(4, pago.getValor()));
        

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
    public int modificar(Pago pago) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "UPDATE pago\n"
                + "   SET cod_pago=? ,Cod_prestamo=?,fecha_pago=?,valor=?, \n"
                + " WHERE cod_pago=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCod_pago()));
        lstPar.add(new Parametro(2, pago.getPrestamo().getCodPre()));
        lstPar.add(new Parametro(3, pago.getFecha_pago()));
        lstPar.add(new Parametro(4, pago.getValor()));
       

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
    public int eliminar(Pago pago) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "DELETE FROM   Pago\n"
                + " WHERE cod_pago=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getCod_pago()));
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
    public Pago obtener(int Cod_pago) throws Exception {
        Pago pago = null;
        String sql = "SELECT cod_pago ,cod_pre,fecha_pago,valor, \n"
                + "  FROM pago where cod_pago=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, Cod_pago));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                pago = new Pago();
                pago.setCod_pago(rst.getInt(1));
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(2));
                pago.setPrestamo(prestamo);
                pago.setFecha_pago(rst.getDate(3));
                pago.setValor(rst.getString(4));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return pago;
    }

    @Override
    public List<Pago> obtener() throws Exception {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT cod_pago ,cod_pre,fecha,valor \n"
                + "  FROM pago";
        Conexion con = new Conexion();
        con.conectar();
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            Pago pago=null;
            while (rst.next()) {
                pago = new Pago();
                pago.setCod_pago(rst.getInt(1));
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(2));
                pago.setPrestamo(prestamo);
                pago.setFecha_pago(rst.getDate(3));
                pago.setValor(rst.getString(4));
                lista.add(pago);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
}

    
    
