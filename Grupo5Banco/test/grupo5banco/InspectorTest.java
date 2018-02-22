
package grupo5banco;

import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.impl.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class InspectorTest {

    public InspectorTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IInspector inspectorDao = new InspectorImpl();
        Inspector inspector = new Inspector(
                1, "Juan", "Pérez",
                "Riobamba", "Ing");
        try {
            filasAfectadas = inspectorDao.insertar(inspector);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        inspector = null;
        try {
            inspector = inspectorDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(inspector != null);

        try {
            inspector.setNombre("Prueba");
            filasAfectadas= inspectorDao.modificar(inspector);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Inspector> lista = new ArrayList<>();
        try {
            lista = inspectorDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= inspectorDao.eliminar(inspector);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
