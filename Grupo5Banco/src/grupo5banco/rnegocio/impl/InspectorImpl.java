package grupo5banco.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import grupo5banco.accesodatos.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.entidades.*;

public class InspectorImpl implements IInspector{
      @Override
    public int insertar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into inspector values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodIs()));
        lstPar.add(new Parametro(2, inspector.getNombre()));
        lstPar.add(new Parametro(3, inspector.getApellido()));
        lstPar.add(new Parametro(4, inspector.getDireccion()));
        lstPar.add(new Parametro(5, inspector.getTitulo()));
             
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
    public int modificar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE inspector"
                + "SET CodIs=?, nombre=?, "
                + "apellido=?, direccion=?, titulo=?"
                + " where CodIs=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodIs()));
        lstPar.add(new Parametro(2, inspector.getNombre()));
        lstPar.add(new Parametro(3, inspector.getApellido()));
        lstPar.add(new Parametro(4, inspector.getDireccion()));
        lstPar.add(new Parametro(5, inspector.getTitulo()));
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
    public int eliminar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM inspector  where CodIs=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodIs()));       
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
    public Inspector obtener(int CodIs) throws Exception {
        Inspector inspector = null;
        String sql =  "UPDATE inspector"
                + "   SET CodIs=?, nombre=?,"
                + " apellido=?, direccion=?, titulo=?"
                + "FROM inspector where CodIs=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodIs));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
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
            if(con!=null)
            con.desconectar();
        }
        return inspector;
    }

    @Override
    public List<Inspector> obtener() throws Exception {
        List<Inspector> lista = new ArrayList<>();
         String sql = "SELECT CodIs, nombre , apellido, direccion, titulo"
                 + " FROM inspector ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Inspector inspector=null;
            while (rst.next()) {
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
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
        
}
