
 
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
public class CuentasAhorro {
    public int insertar(Cueahorros cueahorros) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cuenta_ahorro  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cueahorros.getN_cuenta()));
        lstPar.add(new Parametro(2, cueahorros.getCuenta().getNumerodecuenta()));
        lstPar.add(new Parametro(3, cueahorros.getSaldo()));
        lstPar.add(new Parametro(4, cueahorros.getInteres()));
        

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
    public int modificar(Cueahorros cueahorros) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta_ahorro "
                + "   SET n_cuenta=?, codigo_cuenta=?, saldo=?, interes=?, "
                        + " where id_cuenta_Ahorros=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cueahorros.getN_cuenta()));
        lstPar.add(new Parametro(2, cueahorros.getCuenta().getNumerodecuenta()));
        lstPar.add(new Parametro(3, cueahorros.getSaldo()));
        lstPar.add(new Parametro(4, cueahorros.getInteres()));
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
public int eliminar(Cueahorros cueahorros) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta_ahorro  where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cueahorros.getN_cuenta()));       
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
    public Cueahorros obtener(int codigo) throws Exception {
        Cueahorros cuenta_Ahorros = null;
        String sql = "SELECT *   FROM cuenta_ahorro  where n_cuenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuenta_Ahorros = new Cueahorros();
                cuenta_Ahorros.setN_cuenta(rst.getInt(1));
                ICuentas cuentadao=new CuentasImpl();
                Cuentas cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Ahorros.setCuenta(cuenta);
                cuenta_Ahorros.setSaldo(rst.getInt(3));
                cuenta_Ahorros.setInteres(rst.getInt(3));
            

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuenta_Ahorros;
    }

    @Override
    
    public List<Cueahorros> obtener() throws Exception {
        List<Cueahorros> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cuenta_ahorro  ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cueahorros cuenta_Ahorros=null;
            while (rst.next()) {
                cuenta_Ahorros = new Cueahorros();
                cuenta_Ahorros.setN_cuenta(rst.getInt(1));
                ICuentas cuentadao=new CuentasImpl();
                Cuentas cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Ahorros.setCuenta(cuenta);
                cuenta_Ahorros.setSaldo(rst.getInt(3));
                cuenta_Ahorros.setInteres(rst.getInt(3));
                lista.add(cuenta_Ahorros);
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
