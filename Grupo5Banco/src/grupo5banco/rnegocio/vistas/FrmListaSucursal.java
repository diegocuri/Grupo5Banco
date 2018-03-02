/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Sucursal;
import grupo5banco.rnegocio.impl.SucursalImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DiegoPatricio
 */
public class FrmListaSucursal extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaSucursal() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Sucursaless");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Ciudad");
        
        List<Sucursal> lista = new ArrayList<>();
        try {
            ISucursal sucursalDao = new SucursalImpl();
            lista = sucursalDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Sucursal ins : lista){
            modelo.addRow(new Object[]{ 
            ins.getCodSu(), ins.getCiudad()});            
        }
        tabla.setModel(modelo);        
    }
}
