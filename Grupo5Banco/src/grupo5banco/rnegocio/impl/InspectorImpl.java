package grupo5banco.rnegocio.impl;
import grupo5banco.accesodatos.Conexion;
import grupo5banco.accesodatos.Parametro;
import grupo5banco.rnegocio.dao.IInspector;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Inspector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InspectorImpl implements IInspector {

    @Override
    public int insertar(Inspector inspector) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "INSERT INTO inspector(\n"
                + "            codIs, nombre, apellido, direccion, titulo, )\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodIs()));
        lstPar.add(new Parametro(2, inspector.getNombre()));
        lstPar.add(new Parametro(4, inspector.getApellido()));
        lstPar.add(new Parametro(5, inspector.getDireccion()));
        lstPar.add(new Parametro(6, inspector.getTitulo()));


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
    public int modificar(Inspector inspector) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "UPDATE inspector\n"
                + "   SET codIs=? ,nombre=?, apellido=?, direccion=?, titulo=?, \n"
                + " WHERE codIs=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodIs()));
        lstPar.add(new Parametro(3, inspector.getNombre()));
        lstPar.add(new Parametro(4, inspector.getApellido()));
        lstPar.add(new Parametro(5, inspector.getDireccion()));
        lstPar.add(new Parametro(6, inspector.getTitulo()));

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
    public int eliminar(Inspector inspector) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "DELETE FROM   Inspector\n"
                + " WHERE codId=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodIs()));
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
    public Inspector obtener(int codIs) throws Exception {
        Inspector inspector = null;
        String sql = "SELECT codIs ,nombre, apellido, direccion, titulo \n"
                + "  FROM inspector where codIs=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codIs));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                IInspector ob = new InspectorImpl();
                ISucursal su = new SucursalImpl();
                inspector = new Inspector();
                inspector.setCodIs(rst.getInt(1));
                inspector.setNombre(rst.getString(2));
                inspector.setApellido(rst.getString(3));
                inspector.setDireccion(rst.getString(4));
                inspector.setTitulo(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return inspector;
    }

    @Override
    public List<Inspector> obtener() throws Exception {
        List<Inspector> lista = new ArrayList<>();
        String sql = "SELECT codIs ,nombre, apellido, direccion, titulo \n"
                + "  FROM inspector";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Inspector inspector;
                IInspector ob = new InspectorImpl();
                ISucursal su = new SucursalImpl();
                inspector = new Inspector();
                inspector.setCodIs(rst.getInt(1));
                inspector.setNombre(rst.getString(2));
                inspector.setApellido(rst.getString(3));
                inspector.setDireccion(rst.getString(4));
                inspector.setTitulo(rst.getString(5));
                lista.add(inspector);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    }



