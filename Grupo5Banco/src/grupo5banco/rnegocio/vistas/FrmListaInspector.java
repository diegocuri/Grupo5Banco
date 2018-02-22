
package grupo5banco.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.impl.*;
import grupo5banco.rnegocio.entidades.*;

public class FrmListaInspector extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaInspector() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Inspectors");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Direccion");  
        modelo.addColumn("Titulo");
        
        List<Inspector> lista = new ArrayList<>();
        try {
            IInspector inspectorDao = new InspectorImpl();
            lista = inspectorDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Inspector ins : lista){
            modelo.addRow(new Object[]{ ins.getCodIs(), 
            ins.getNombre(), ins.getApellido(), ins.getDireccion(), ins.getTitulo()});            
        }
        tabla.setModel(modelo);        
    }
}
