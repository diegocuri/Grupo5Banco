
package grupo5banco.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.impl.*;
import grupo5banco.rnegocio.entidades.*;

public class FrmListaEmpleado extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaEmpleado() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Empleadoes");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Sucursal");        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha vinculacion");  
        modelo.addColumn("Antiguedad");
        
        List<Empleado> lista = new ArrayList<>();
        try {
            IEmpleado empleadoDao = new EmpleadoImpl();
            lista = empleadoDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Empleado ins : lista){
            modelo.addRow(new Object[]{ ins.getCodEpl(), ins.getSucursal().getCodSu(),
            ins.getNombre(), ins.getApellido(), ins.getFecha_vinculacion(), ins.getAntiguedad()});            
        }
        tabla.setModel(modelo);        
    }
}
