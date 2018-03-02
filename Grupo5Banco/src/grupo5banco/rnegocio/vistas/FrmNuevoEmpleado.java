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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.util.List;

public class FrmNuevoEmpleado extends JInternalFrame {

    List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;
    JLabel lblTitulo;
    JTextField txtTitulo;
    JLabel lblCodEpl;
    JTextField txtCodEpl;
    JLabel lblSucursal;
    JLabel lblNombre;
    JTextField txtNombre;
    JLabel lblApellido;
    JTextField txtApellido;
    JLabel lblfecha_vinculacion;
    JTextField txtfecha_vinculacion;
    JLabel lblantiguedad;
    JTextField txtantiguedad;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoEmpleado() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
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

        txtCodEpl = new JTextField(2);
        txtCodEpl = new JTextField(2);
        txtNombre = new JTextField(2);
        txtApellido = new JTextField(2);
        txtfecha_vinculacion = new JTextField(2);
        txtfecha_vinculacion = new JTextField(2);
        txtantiguedad = new JTextField(2);
        // cmbSexo = new JComboBox(new String[]{"masculino", "femenino"});
        cargarSucursal();
        cmbSucursal = new JComboBox(lstSucursal.toArray());
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(lblCodEpl);
        pnlCentral.add(txtCodEpl);
        pnlCentral.add(lblSucursal);
        pnlCentral.add(cmbSucursal);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblfecha_vinculacion);
        pnlCentral.add(txtfecha_vinculacion);
        pnlCentral.add(lblantiguedad);
        pnlCentral.add(txtantiguedad);

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
        FrmNuevoEmpleado frmMenu = new FrmNuevoEmpleado();
        frmMenu.setVisible(true);
    }

    public void cargarSucursal() {
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las sucursales!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IEmpleado empleadoDao = new EmpleadoImpl();
        Empleado empleado = new Empleado();
        empleado.setCodEpl(Integer.parseInt(txtCodEpl.getText()));
        empleado.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
        empleado.setNombre(txtNombre.getText());
        empleado.setApellido(txtApellido.getText());

        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            empleado.setFecha_vinculacion(formatoFecha.parse(txtfecha_vinculacion.getText()));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        empleado.setAntiguedad(Integer.parseInt(txtantiguedad.getText()));

        try {
            if (empleadoDao.insertar(empleado) > 0) {
                JOptionPane.showMessageDialog(this, "Guardado Correctamente!!",
                        "Transacción", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error desconocido: ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar!!: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
