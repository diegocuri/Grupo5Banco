package grupo5banco.rnegocio.impl;

import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.IEmpleado;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoImpl implements IEmpleado {

    @Override
    public int insertar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO empleado(\n"
                + "            codEpl,codSu, nombre, apellido, fecha_vinculacion,antiguedad, )\n"
                + "    VALUES (?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodEpl()));
        lstPar.add(new Parametro(2, empleado.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, empleado.getNombre()));
        lstPar.add(new Parametro(4, empleado.getApellido()));
        lstPar.add(new Parametro(5, empleado.getFecha_vinculacion()));
        lstPar.add(new Parametro(6, empleado.getAntiguedad()));

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
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE empleado\n"
                + "   SET codEpl=? ,codSu=? nombre=?, apellido=?, fecha_vinculacion=?, antiguedad=?, , \n"
                + " WHERE codSu=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodEpl()));
        lstPar.add(new Parametro(2, empleado.getSucursal().getCodSu()));
        lstPar.add(new Parametro(3, empleado.getNombre()));
        lstPar.add(new Parametro(4, empleado.getApellido()));
        lstPar.add(new Parametro(5, empleado.getFecha_vinculacion()));
        lstPar.add(new Parametro(6, empleado.getAntiguedad()));

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
    public int eliminar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM   Empleado\n"
                + " WHERE codEpl=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCodEpl()));
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
    public Empleado obtener(int codEpl) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT codEpl ,codSu, nombre, apellido, fecha_viculacion,antiguedad \n"
                + "  FROM empleado where codEpl=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codEpl));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                IEmpleado ob = new EmpleadoImpl();
                ISucursal su = new SucursalImpl();
                empleado = new Empleado();
                empleado.setCodEpl(rst.getInt(1));
                empleado.setSucursal(su.obtener(rst.getInt(2)));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setFecha_vinculacion(rst.getDate(5));
                empleado.setAntiguedad(rst.getInt(6));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT codEpl ,codSu, nombre, apellido, fecha_viculacion,antiguedad \n"
                + "  FROM empleado";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Empleado empleado;
                IEmpleado ob = new EmpleadoImpl();
                ISucursal su = new SucursalImpl();
                empleado = new Empleado();
                empleado.setCodEpl(rst.getInt(1));
                empleado.setSucursal(su.obtener(rst.getInt(2)));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setFecha_vinculacion(rst.getDate(5));
                empleado.setAntiguedad(rst.getInt(6));
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
