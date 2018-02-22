
package grupo5banco.rnegocio.impl;
import grupo5banco.accesodatos.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.impl.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentasImpl implements ICuentas {
    
 @Override
     
    public int insertar(Cuentas cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cuentas  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerodecuenta()));
//        lstPar.add(new Parametro(2, cuenta.getCliente().getCodigo_cliente()));

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
    public int modificar(Cuentas cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuentas"
                + "   SET codCU=?, codigo_cliente=? where id_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerodecuenta()));
//        lstPar.add(new Parametro(2, cuenta.getCliente().getCodigo_cliente()));
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
    public int eliminar(Cuentas cuenta) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta  where codigo_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNumerodecuenta()));       
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
    public Cuentas obtener(int codigo) throws Exception {
        Cuentas cuenta = null;
        String sql = "SELECT *   FROM cuentas where codCu=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuenta = new Cuentas();
                cuenta.setNumerodecuenta(rst.getInt(1));
//                ICliente clientedao= new ClienteImpl();
//                Cliente cliente=clientedao.obtener(rst.getInt(2));
//                cuenta.setCliente(cliente);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuenta;
    }

    @Override
    public List<Cuentas> obtener() throws Exception {
        List<Cuentas> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cuenta ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuentas cuenta=null;
            while (rst.next()) {
                
                cuenta = new Cuentas();
                cuenta.setNumerodecuenta(rst.getInt(1));
//                ICliente clientedao= new ClienteImpl();
//                Cliente cliente=clientedao.obtener(rst.getInt(2));
//                cuenta.setCliente(cliente);
                lista.add(cuenta);
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