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
public class PedidoImpl implements IPedido{

    @Override
    public int insertar(Pedido pedido) throws Exception {
    
      int filasAfectadas = 0;
        String sqlC = "INSERT INTO Producto (num_pedido, CodPre, CodCL , codIs) VALUES (?,?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, pedido.getNum_pedido()));
        listParam.add(new Parametro(2, pedido.getPrestamo().getCodPre()));
        listParam.add(new Parametro(3, pedido.getPrestamo().getCodPre()));
        listParam.add(new Parametro(4, pedido.getInspector().getCodIs()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutaComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;    
    }

    @Override
    public int modificar(Pedido pedido) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE Producto SET num_pedido=?, CodPre=?, CodCL=?, codIs=? WHERE num_pedido=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, pedido.getNum_pedido()));
        listParam.add(new Parametro(2, pedido.getPrestamo().getCodPre()));
        listParam.add(new Parametro(3, pedido.getPrestamo().getCodPre()));
        listParam.add(new Parametro(4, pedido.getInspector().getCodIs()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutaComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;}

    @Override
    public int eliminar(Pedido pedido) throws Exception {
       int filasAfectadas = 0;
        String sqlC = "DELETE FROM DetallePedido WHERE codigoDetallePedido=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, pedido.getNum_pedido()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutaComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;}

    @Override
    public Pedido obtener(int codigo) throws Exception {
        Pedido pedido  = null;
        String sqlC = "SELECT num_pedido, CodPre, CodCL , codIs FROM Pedido Where num_pedido=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, codigo));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            Inspector inspector = null; 
            IInspector inspectorDao=new InspectorImpl();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            while (rst.next()) {
                pedido = new Pedido();
                inspector = new Inspector();
                pedido.setNum_pedido(rst.getInt(1));
                pedido.getInspector();
                inspector = inspectorDao.obtener(rst.getInt(2));
                pedido.setInspector(inspector);
                pedido.setNum_pedido(rst.getInt(3));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return pedido; }

    @Override
    public List<Pedido> obtener() throws Exception {
        ArrayList<Pedido> lstPedido=new ArrayList<>();
        Pedido pedido = null;
        String sqlC = "SELECT num_pedido, CodPre, CodCL , codIs FROM Pedido";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            Inspector inspector = null;
            IInspector inspectorDao=new InspectorImpl();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                pedido = new Pedido();
                inspector = new Inspector();
                pedido.setNum_pedido(rst.getInt(1));
                pedido.getInspector();
                inspector = inspectorDao.obtener(rst.getInt(2));
                pedido.setInspector(inspector);
                pedido.setNum_pedido(rst.getInt(2));
           
                lstPedido.add(pedido);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return lstPedido;}
    
    
    
}
