/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.impl;

import grupo5banco.accesodatos.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {

        int numFilasAfectadas = 0;
        String sql = "INSERT INTO empleado(\n"
                + "            codCL,id_sucursal, cedula,nombre, apellido,cedula,Celular,email )\n"
                + "    VALUES (?, ?, ?, ?, ?, ?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodCL()));
        lstPar.add(new Parametro(2, cliente.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, cliente.getNombre()));
        lstPar.add(new Parametro(4, cliente.getApellido()));
        lstPar.add(new Parametro(5, cliente.getCedula()));
        lstPar.add(new Parametro(5, cliente.getCelular()));
        lstPar.add(new Parametro(6, cliente.getEmail()));

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
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente\n"
                + "   SET codCL=? ,codSu_sucursal=? nombre=?, apellido=?, cedula=?, celular=?, email, \n"
                + " WHERE codCL=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(2, cliente.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, cliente.getNombre()));
        lstPar.add(new Parametro(4, cliente.getApellido()));
        lstPar.add(new Parametro(5, cliente.getCedula()));
        lstPar.add(new Parametro(5, cliente.getCelular()));
        lstPar.add(new Parametro(6, cliente.getEmail()));

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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM   Cliente\n"
                + " WHERE codCL=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodCL()));
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
    public Cliente obtener(int codCL) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT codCl ,codSu_sucursal, nombre, apellido, cedula,celular,email \n"
                + "  FROM cliente where codCL=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codCL));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                ICliente ob = new ClienteImpl();
                ISucursal su = new SucursalImpl();
                cliente = new Cliente();
                cliente.setCodCL(rst.getInt(1));
                cliente.setSucursal(su.obtener(rst.getInt(2)));
                cliente.setCedula(rst.getString(3));
                cliente.setNombre(rst.getString(4));
                cliente.setApellido(rst.getString(5));
                cliente.setCelular(rst.getString(6));
                cliente.setEmail(rst.getString(7));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
          List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT codCL ,codSu_sucursal, cedula,nombre, apellido, celular,email \n"
                + "  FROM cliente";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Cliente cliente;
                ICliente ob = new ClienteImpl();
                ISucursal su = new SucursalImpl();
                cliente = new Cliente();
                cliente.setCodCL(rst.getInt(1));
                cliente.setSucursal(su.obtener(rst.getInt(2)));
                cliente.setCedula(rst.getString(3));
                cliente.setNombre(rst.getString(4));
                cliente.setApellido(rst.getString(5));
                cliente.setCelular(rst.getString(6));
                cliente.setEmail(rst.getString(7));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;

    }

}
