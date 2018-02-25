/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.impl.*;
import grupo5banco.rnegocio.entidades.*;

public class FrmListaPedido extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaPedido() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Pedidos");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Numero de pedido");
        modelo.addColumn("Cliente");
        modelo.addColumn("Inspector");
        modelo.addColumn("Numero de prestamo");
        
        List<Pedido> lista = new ArrayList<>();
        try {
            IPedido pedidoDao = new PedidoImpl();
            lista = pedidoDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Pedido est : lista){
            modelo.addRow(new Object[]{ est.getNum_pedido(),est.getCliente(), 
            est.getInspector(), est.getPrestamo()});            
        }
        tabla.setModel(modelo);        
    }
    
}
