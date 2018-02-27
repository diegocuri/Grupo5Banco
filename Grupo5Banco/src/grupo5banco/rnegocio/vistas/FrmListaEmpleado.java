
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.IEmpleado;
import grupo5banco.rnegocio.entidades.Empleado;
import grupo5banco.rnegocio.impl.EmpleadoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaEmpleado  extends JInternalFrame {
    
JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaEmpleado () {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Empleados");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha vinculacion");
        modelo.addColumn("Fecha antiguedad");
        
        List<Empleado> lista = new ArrayList<>();
        try {
            IEmpleado empleadoDao = new EmpleadoImpl();
            lista = empleadoDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Empleado empl : lista){
            modelo.addRow(new Object[]{ empl.getCodEpl(), 
            empl.getNombre(), empl.getApellido(), empl.getFecha_vinculacion().toString(),empl.getAntiguedad()});            
        }
        tabla.setModel(modelo);        
    }
}
