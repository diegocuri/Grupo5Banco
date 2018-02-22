/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.entidades.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.impl.*; 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.util.List;


public class FmrNuevoEmpleado extends JInternalFrame {

    List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;

    JPanel pnlCentral;
    JPanel pnlPie;
    JLabel lblTitulo;
    JTextField txtTitulo;

    JLabel lblCodEpl;
    JTextField txtCodEpl;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblApellido;
    JTextField txtApellido;
    JLabel lblfecha_vinculacion;
    JTextField txtfecha_vinculacion;
    JLabel lblantiguedad;
    JTextField txtantiguedad;

    JLabel lblSucursal;
    JLabel lblCiudad;
    JComboBox cmdCiudad;
    JButton btnLimpiar;
    JButton btnAceptar;

    public FmrNuevoEmpleado() {
        this.setSize(400, 600);
        this.setLayout(new BorderLayout());
        pnlCentral = new JPanel();
        pnlPie = new JPanel();

        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo = new JLabel("DATOS DEL EMPLEADO");
        lblCodEpl = new JLabel("CODIGO: ");
        txtCodEpl = new JTextField(1);
        lblSucursal = new JLabel("SUCURSAL:");
        lblNombre = new JLabel("NOMBRE: ");
        txtNombre = new JTextField(2);
        lblApellido = new JLabel("APELLIDO: ");
        txtApellido = new JTextField(2);
        lblfecha_vinculacion = new JLabel("FECHA VINCULACION: ");
        txtfecha_vinculacion = new JTextField(2);
        lblantiguedad = new JLabel("ANTIGUEDAD: ");
        txtantiguedad = new JTextField(2);

  

        pnlCentral.add(lblCodEpl);
        pnlCentral.add(txtCodEpl);
     
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblfecha_vinculacion);
        pnlCentral.add(txtfecha_vinculacion);
        pnlCentral.add(lblantiguedad);
        pnlCentral.add(txtantiguedad);
     
        lblSucursal = new JLabel("SUCURSAL");
        cmbSucursal = new JComboBox(new String[]{" Ciudad", "Quito", "Cuenca", "Santo Domingo", "Machala", "Eloy Alfaro Duran", "Manta", "Portoviejo", "Riobamba", "Ambato"});
        pnlCentral.add(lblSucursal);
        pnlCentral.add(cmbSucursal);
     
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

        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
       FmrNuevoEmpleado frmMenu = new   FmrNuevoEmpleado();
        frmMenu.setVisible(true);
    }

    public void cargarSucursal() {
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
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
