/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.ICliente;
import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Cliente;
import grupo5banco.rnegocio.entidades.Sucursal;
import grupo5banco.rnegocio.impl.ClienteImpl;
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

/**
 *
 * @author DiegoPatricio
 */
public class FrmNuevoCliente extends JInternalFrame{
    List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;
    JLabel lblCodigo;
    JLabel lblSucursal;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblApellido;
    JLabel lblCelular;
    JLabel lblEmail;
    
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtSucursal;
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtCelular;
    JTextField txtEmail; 
   
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoCliente() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Cliente");
        
        lblCodigo= new JLabel("Código:");
        lblSucursal= new JLabel("Sucursal:");
        lblCedula= new JLabel("Cédula:");
        lblNombre= new JLabel("Nombre:");
        lblApellido= new JLabel("Apellido:");
        lblCelular= new JLabel("Celular:");
        lblEmail= new JLabel("Email:");
        

        txtCodigo = new JTextField(2);
        txtCedula= new JTextField(2);
        txtNombre= new JTextField(2);
        txtApellido= new JTextField(2);
        txtCelular= new JTextField(2);
        txtEmail= new JTextField(2);
        cargarSucursales();
        cmbSucursal= new JComboBox(lstSucursal.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblSucursal);
        pnlCentral.add(cmbSucursal);
        
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(lblCelular);
        pnlCentral.add(txtCelular);
        pnlCentral.add(lblEmail);
        pnlCentral.add(txtEmail);
        
                
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
        FrmNuevoCliente frmMenu= new FrmNuevoCliente();
        frmMenu.setVisible(true);
    } 
    public void cargarSucursales(){
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los sucursales!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente();
        cliente.setCodCl(Integer.parseInt(txtCodigo.getText()));
        cliente.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setCelular(txtCelular.getText());          
        cliente.setEmail(txtEmail.getText());
        
        
        try {
            if(clienteDao.insertar(cliente)>0){
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
 