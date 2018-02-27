/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.IPago;
import grupo5banco.rnegocio.dao.IPrestamo;
import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.impl.PagoImpl;
import grupo5banco.rnegocio.impl.PrestamoImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ANTHONY
 */
public class FrmNuevoPago extends JInternalFrame  {
    List<Prestamo> lstPrestamo;
    JComboBox<Prestamo> cmbPrestamo;

    JLabel lblCod_pago;
    JLabel lblCod_Pre;
    JLabel lblFecha_pago;
    JLabel lblValor;
    JLabel lblTitulo;
    
    JTextField txtCod_pago;
    JTextField txtFecha_pago;
    JTextField txtValor;



 
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoPago() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));

        lblTitulo = new JLabel("DATOS DE PAGO");
        lblCod_pago = new JLabel("codigo pago: ");
        txtCod_pago = new JTextField(1);
        lblCod_Pre = new JLabel("PRESTAMO:");
        
        lblFecha_pago=new JLabel("fecha de pago:");
        txtFecha_pago=new JTextField(2);
        lblValor=new JLabel("valor de pago:");
        txtValor=new JTextField(2);
     
        cargarPrestamo();
        cmbPrestamo= new JComboBox(lstPrestamo.toArray());
        pnlCentral.add(lblCod_pago);
        pnlCentral.add(txtCod_pago);
        pnlCentral.add(lblCod_Pre);
        pnlCentral.add(cmbPrestamo);
        pnlCentral.add(lblFecha_pago);
        pnlCentral.add(txtFecha_pago);
        pnlCentral.add(lblValor);
        pnlCentral.add(txtValor);
        
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }

    public static void main(String[] args) {
       FrmNuevoPago frmMenu = new   FrmNuevoPago();
        frmMenu.setVisible(true);
    }

    public void cargarPrestamo() {
        IPrestamo prestamoDao = new PrestamoImpl();
        try {
            lstPrestamo = prestamoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar prestamos!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }
    
   
    public void btnAceptarActionListener(ActionEvent e) {
        IPago pagoDao = new PagoImpl();
        Pago pago = new Pago();
        pago.setCod_pago(Integer.parseInt(txtCod_pago.getText()));
        pago.setPrestamo((Prestamo) cmbPrestamo.getSelectedItem());
        DateFormat Fecha_pago = new SimpleDateFormat("yyyy-MM-dd");
        try {
            pago.setFecha_pago(Fecha_pago.parse(txtFecha_pago.getText()));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        pago.setValor(txtCod_pago.getText());
        
     
        try {
            if(pagoDao.insertar(pago)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
      
    }
}
