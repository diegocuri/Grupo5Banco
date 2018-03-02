package grupo5banco.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.impl.*;
import grupo5banco.rnegocio.entidades.*;

public class FrmListaCliente extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaCliente() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Clientes");
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
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Celular");  
        modelo.addColumn("Email");
        
        List<Cliente> lista = new ArrayList<>();
        try {
            ICliente clienteDao = new ClienteImpl();
            lista = clienteDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente ins : lista){
            modelo.addRow(new Object[]{ ins.getCodCl(), ins.getSucursal().getCodSu(), ins.getCedula(),
            ins.getNombre(), ins.getApellido(), ins.getCelular(), ins.getEmail()});            
        }
        tabla.setModel(modelo);        
    }
}
