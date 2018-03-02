/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.IPrestamo;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.impl.PrestamoImpl;
import grupo5banco.rnegocio.impl.SucursalImpl;
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

public class FrmNuevoPrestamo extends JInternalFrame{
    List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;
    JLabel lblCodigo;
    JLabel lblSucursal;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
     
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoPrestamo() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Prestamo");
        
        lblCodigo= new JLabel("Código:");
        lblSucursal= new JLabel("Sucursal:");

        txtCodigo = new JTextField(2);
             
        cargarSucursales();
        cmbSucursal= new JComboBox(lstSucursal.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblSucursal);
        pnlCentral.add(cmbSucursal);
        
                
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
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoPrestamo frmMenu= new FrmNuevoPrestamo();
        frmMenu.setVisible(true);
    } 
    public void cargarSucursales(){
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los sucursals!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IPrestamo prestamoDao = new PrestamoImpl();
        Prestamo prestamo = new Prestamo();
        prestamo.setCodPre(Integer.parseInt(txtCodigo.getText()));
        prestamo.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
        
        try {
            if(prestamoDao.insertar(prestamo)>0){
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
 