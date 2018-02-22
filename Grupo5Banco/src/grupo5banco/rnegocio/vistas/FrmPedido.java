/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FrmPedido extends JInternalFrame{
    
    List<Prestamo> lstPrestamo;
    JComboBox<Prestamo> cmbprestamo;
    
    List<Cliente> lstCliente;
    JComboBox<Sucursal> cmbCliente;

    List<Inspector> lstInspector;
    JComboBox<Inspector> cmbinspector;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    JLabel lblTitulo;
    JTextField txtTitulo;

    JLabel lblPedido;
    JTextField txtCodPedido;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JLabel lblCliente;
    JLabel lbLinspector;
    JLabel lbLPrestamo;
    
    
    public  FrmPedido(){
        
        this.setSize(400, 600);
        this.setLayout(new BorderLayout());
        pnlCentral = new JPanel();
        pnlPie = new JPanel();

        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo = new JLabel("PEDIDO");
        lblPedido = new JLabel("NUMERO DE PEDIDO: ");
        txtCodPedido = new JTextField(1);
        
        pnlCentral.add(lblPedido);
        pnlCentral.add(txtCodPedido);
        
        lblCliente = new JLabel("CODIGO DE CLIENTE");
        cmbCliente = new JComboBox(new String[]{" 001", " 002", " 003", " 004", " 005", " 006"});
        pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);
        
        lbLinspector = new JLabel("CODIGO DE INSPECTOR");
        cmbinspector = new JComboBox(new String[]{" 001", " 002", " 003", " 004", " 005", " 006"});
        pnlCentral.add(lbLinspector);
        pnlCentral.add(cmbinspector);
        
        lbLPrestamo = new JLabel("CODIGO DEL PRESTAMO");
        cmbprestamo = new JComboBox(new String[]{" 001", " 002", " 003", " 004", " 005", " 006"});
        pnlCentral.add(lbLPrestamo);
        pnlCentral.add(cmbprestamo);
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });
           
                
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
    }
    
    
    public static void main(String[] args) {
       FrmPedido frmMenu = new   FrmPedido();
        frmMenu.setVisible(true);
    }
    
    public void cargarCliente() {
        ICliente clienteDao = new  ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las ciudades!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarInspector() {
        IInspector inspectorDao = new  InspectorImpl();
        try {
            lstInspector = inspectorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las ciudades!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarPrestamo() {
        IPrestamo prestamoDao = new  prestamoImpl ();
        try {
            lstPrestamo = prestamoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las ciudades!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnAceptarActionListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "proceso correcto!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
    }
}
