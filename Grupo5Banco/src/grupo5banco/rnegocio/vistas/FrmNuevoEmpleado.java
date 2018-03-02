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

public class FrmNuevoEmpleado extends JInternalFrame{
    List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;
    JLabel lblCodigo;
    JLabel lblSucursal;
    JLabel lblNombres;
    JLabel lblApellidos;
    JLabel lblFecha_Vinculacion;
    JLabel lblAntiguedad;
   
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtNombres;
    JTextField txtApellidos;
    JTextField txtFecha_Vinculacion;
    JTextField txtAntiguedad;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoEmpleado() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Empleado");
        
        lblCodigo= new JLabel("Código:");
        lblNombres= new JLabel("Nombres:");
        lblApellidos= new JLabel("Apellidos:");
        lblFecha_Vinculacion= new JLabel("Fecha Nacimiento:");
        lblAntiguedad= new JLabel("Fecha Ingreso:");
        lblSucursal= new JLabel("Sucursal:");

        txtCodigo = new JTextField(2);
        txtNombres= new JTextField(2);
        txtApellidos= new JTextField(2);
        txtFecha_Vinculacion= new JTextField(2);
       txtAntiguedad= new JTextField(2);
        
       cargarSucursals();
        cmbSucursal= new JComboBox(lstSucursal.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblNombres);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);
        pnlCentral.add(lblFecha_Vinculacion);
        pnlCentral.add(txtFecha_Vinculacion);
        pnlCentral.add(lblAntiguedad);
        pnlCentral.add(txtAntiguedad);
        
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
        FrmNuevoEmpleado frmMenu= new FrmNuevoEmpleado();
        frmMenu.setVisible(true);
    } 
    public void cargarSucursals(){
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los sucursals!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IEmpleado empleadoDao = new EmpleadoImpl();
        Empleado empleado = new Empleado();
        empleado.setCodEpl(Integer.parseInt(txtCodigo.getText()));
        empleado.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
        empleado.setNombre(txtNombres.getText());
        empleado.setApellido(txtApellidos.getText());
          
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        try {                        
            empleado.setFecha_vinculacion(formatoFecha.parse(txtFecha_Vinculacion.getText()));
            
            } catch (Exception ex) {
              JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }
    
    empleado.setAntiguedad(Integer.parseInt(txtAntiguedad.getText()));  
        
    
        
        try {
            if(empleadoDao.insertar(empleado)>0){
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
 