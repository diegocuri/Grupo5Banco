package grupo5banco.rnegocio.impl;

import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.IEmpleado;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Empleado;
import grupo5banco.rnegocio.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoImpl implements IEmpleado {

    @Override
    public int insertar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into empleado  values "
                +"(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodEpl()));
        lstPar.add(new Parametro(2, empleado.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, empleado.getNombre()));
        lstPar.add(new Parametro(4, empleado.getApellido()));
        lstPar.add(new Parametro(5, empleado.getFecha_vinculacion()));
        lstPar.add(new Parametro(6, empleado.getAntiguedad()));

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
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE empleado"
                + "   SET codEpl=?, codSu=?, nombre=?, apellido=?, "
                + "fecha_vinculacion=?, antiguedad=?"
                + " where codEpl=?";
        List<Parametro> lstPar = new ArrayList<>();
        
        lstPar.add(new Parametro(1, empleado.getCodEpl()));
        lstPar.add(new Parametro(2, empleado.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, empleado.getNombre()));
        lstPar.add(new Parametro(4, empleado.getApellido()));
        lstPar.add(new Parametro(5, empleado.getFecha_vinculacion()));
        lstPar.add(new Parametro(6, empleado.getAntiguedad()));
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
    public int eliminar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM empleado  where codEpl=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodEpl()));       
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
    public Empleado obtener(int codigo) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT codEpl, codSu, nombre, apellido, fecha_vinculacion, antiguedad"
                + "FROM empleado where codEpl=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setCodEpl(rst.getInt(1));
                 ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
                empleado.setSucursal(sucursal);
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setFecha_vinculacion(rst.getDate(5));
                empleado.setAntiguedad(rst.getInt(6));
          
  
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
         String sql = "SELECT codCl, codSu, cedula, nombre, apellido, celular, email"
                + "FROM empleado ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Empleado empleado=null;
            while (rst.next()) {
                empleado = new Empleado();
                empleado.setCodEpl(rst.getInt(1));
                 ISucursal sucursaldao = new SucursalImpl();
                Sucursal sucursal = sucursaldao.obtener(rst.getInt(2));
                empleado.setSucursal(sucursal);
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setFecha_vinculacion(rst.getDate(5));
                empleado.setAntiguedad(rst.getInt(6));
          
               lista.add(empleado);
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
