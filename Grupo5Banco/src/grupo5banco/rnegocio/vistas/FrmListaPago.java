/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.IPago;
import grupo5banco.rnegocio.dao.IPedido;
import grupo5banco.rnegocio.entidades.Pago;
import grupo5banco.rnegocio.entidades.Pedido;
import grupo5banco.rnegocio.impl.PagoImpl;
import grupo5banco.rnegocio.impl.PedidoImpl;
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
 * @author ANTHONY
 */
public class FrmListaPago extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public FrmListaPago() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo= new JLabel("Listado de Pagos");
        tabla = new JTable();
        jscTabla= new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("codigo pago");
        modelo.addColumn("Cod prestamo");
        modelo.addColumn("fecha");
        modelo.addColumn("valor de prestamo");
        
        List<Pago> lista = new ArrayList<>();
        try {
            IPago pagoDao = new PagoImpl();
            lista = pagoDao.obtener();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Pago pa : lista){
            modelo.addRow(new Object[]{ pa.getCod_pago(),pa.getPrestamo(), 
            pa.getFecha_pago(), pa.getValor()});            
        }
        tabla.setModel(modelo);        
    }
}
