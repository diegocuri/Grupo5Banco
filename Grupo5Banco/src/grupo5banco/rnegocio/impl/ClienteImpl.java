package grupo5banco.rnegocio.impl;

import com.sun.javafx.tk.FocusCause;
import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.ICliente;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Cliente;
import grupo5banco.rnegocio.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteImpl implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cliente  values "
                +"(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodCl()));
        lstPar.add(new Parametro(2, cliente.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, cliente.getCedula()));
        lstPar.add(new Parametro(4, cliente.getNombre()));
        lstPar.add(new Parametro(5, cliente.getApellido()));
        lstPar.add(new Parametro(6, cliente.getCelular()));
        lstPar.add(new Parametro(7, cliente.getEmail()));
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
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente"
                + "   SET codEpl=?, codSu=?, nombre=?, apellido=?, fecha_vinculacion=?, "
                + "antiguedad=? where codEpl=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, cliente.getCodCl()));
        lstPar.add(new Parametro(2, cliente.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, cliente.getCedula()));
        lstPar.add(new Parametro(4, cliente.getNombre()));
        lstPar.add(new Parametro(5, cliente.getApellido()));
        lstPar.add(new Parametro(6, cliente.getCelular()));
        lstPar.add(new Parametro(7, cliente.getEmail()));
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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente  where codCl=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodCl()));       
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
    public Cliente obtener(int codCl) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT codCl, codSu, cedula, nombre, apellido, celular, "
                + "email FROM cliente where codCl=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codCl));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodCl(rst.getInt(1));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
                cliente.setSucursal(sucursal);
                cliente.setCedula(rst.getString(3));
                cliente.setNombre(rst.getString(4));
                cliente.setApellido(rst.getString(5));
                cliente.setCelular(rst.getString(6));
                cliente.setEmail(rst.getString(7));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql = "SELECT codCl, codSu, cedula, nombre, apellido, celular, "
                + "email  FROM cliente ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();               
                cliente.setCodCl(rst.getInt(1));
                ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
                cliente.setSucursal(sucursal);
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
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
}
