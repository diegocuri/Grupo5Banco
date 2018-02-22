/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.impl;
import grupo5banco.accesodatos.*;
import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.dao.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stian
 */
public class CuentasCreditoImpl implements ICu_Credito{
    
         @Override
    
      public int insertar(Cuecredito cuecredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cuenta_credito  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuecredito.getN_cuenta()));
        lstPar.add(new Parametro(2, cuecredito.getCuenta().getNumerodecuenta()));
        lstPar.add(new Parametro(3, cuecredito.getSaldo()));
        lstPar.add(new Parametro(4, cuecredito.getU_sobregiro()));
        

        Conexion con = null;
        try {
            con = new Conexion();
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
    public int modificar(Cuecredito cuecredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta_credito"
                + "   SET n_cuenta=?, codigo_cuenta=?, saldo=?, u_sobregiro=?, "
                        + " where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuecredito.getN_cuenta()));
        lstPar.add(new Parametro(2, cuecredito.getCuenta().getNumerodecuenta()));
        lstPar.add(new Parametro(3, cuecredito.getSaldo()));
        lstPar.add(new Parametro(4, cuecredito.getU_sobregiro()));
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
public int eliminar(Cuecredito cuecredito) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta_credito  where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuecredito.getN_cuenta()));       
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
    public Cuecredito obtener(int codigo) throws Exception {
        Cuecredito cuenta_Credito = null;
        String sql = "SELECT *   FROM cuenta_credito where n_cuenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuenta_Credito = new Cuecredito();
                cuenta_Credito.setN_cuenta(rst.getInt(1));
                ICuentas cuentadao=new CuentasImpl();
                Cuentas cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Credito.setCuenta(cuenta);
                cuenta_Credito.setSaldo(rst.getInt(3));
                cuenta_Credito.setU_sobregiro(rst.getInt(4));
            

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuenta_Credito;
    }

    @Override
    
    public List<Cuecredito> obtener() throws Exception {
        List<Cuecredito> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cuenta_credito ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuecredito cuenta_Credito=null;
            while (rst.next()) {
                cuenta_Credito = new Cuecredito();
                cuenta_Credito.setN_cuenta(rst.getInt(1));
                ICuentas cuentadao=new CuentasImpl();
                Cuentas cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Credito.setCuenta(cuenta);
                cuenta_Credito.setSaldo(rst.getInt(3));
                cuenta_Credito.setU_sobregiro(rst.getInt(4));
                lista.add(cuenta_Credito);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }

    
}
