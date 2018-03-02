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

/**
 *
 * @author Usuario
 */
public class PedidoImpl implements IPedido {

    @Override
    public int insertar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into pedido  values "
                +"(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pedido.getNum_pedido()));
        lstPar.add(new Parametro(2, pedido.getPrestamo().getCodPre()));
        lstPar.add(new Parametro(3, pedido.getCliente().getCodCl()));
        lstPar.add(new Parametro(4, pedido.getInspector().getCodIs()));
        
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
    public int modificar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE pedido"
                   + "   SET num_pedido=?, codPre=?, codCl=?, codIs=?"
                   + "   where num_pedido=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pedido.getNum_pedido()));
        lstPar.add(new Parametro(2, pedido.getPrestamo().getCodPre()));
        lstPar.add(new Parametro(3, pedido.getCliente().getCodCl()));
        lstPar.add(new Parametro(4, pedido.getInspector().getCodIs()));
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
    public int eliminar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM pedido  where num_pedido=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pedido.getNum_pedido()));       
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
    public Pedido obtener(int codigo) throws Exception {
        Pedido pedido = null;
        String sql = "SELECT num_pedido, codPre, codCl,"
                + "codIs FROM pedido where num_pedido=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                pedido = new Pedido();
                pedido.setNum_pedido(rst.getInt(1));
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(2));
                pedido.setPrestamo(prestamo);
                
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(3));
                pedido.setCliente(cliente);
                
                IInspector inspectordao = new InspectorImpl();
                Inspector inspector = inspectordao.obtener(rst.getInt(4));
                pedido.setCliente(cliente);
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return pedido;
    }

    @Override
    public List<Pedido> obtener() throws Exception {
        List<Pedido> lista = new ArrayList<>();
         String sql = "SELECT codEpl, codSu, nombre, apellido, fecha_vinculacion, "
                + "antiguedad  FROM pedido ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Pedido pedido=null;
            while (rst.next()) {
                pedido = new Pedido();
                pedido.setNum_pedido(rst.getInt(1));
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(2));
                pedido.setPrestamo(prestamo);
                
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(3));
                pedido.setCliente(cliente);
                
                IInspector inspectordao = new InspectorImpl();
                Inspector inspector = inspectordao.obtener(rst.getInt(4));
                pedido.setCliente(cliente);
                
                lista.add(pedido);
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
