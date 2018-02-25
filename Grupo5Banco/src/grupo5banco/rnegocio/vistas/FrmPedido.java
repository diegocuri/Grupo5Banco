 

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
        
        
        
        lblCliente = new JLabel("CODIGO DE CLIENTE");
        cmbCliente = new JComboBox(new String[]{" 001", " 002", " 003", " 004", " 005", " 006"});
       
        lbLinspector = new JLabel("CODIGO DE INSPECTOR");
        cmbinspector = new JComboBox(new String[]{" 001", " 002", " 003", " 004", " 005", " 006"});
        
        
        lbLPrestamo = new JLabel("CODIGO DEL PRESTAMO");
        cmbprestamo = new JComboBox(new String[]{" 001", " 002", " 003", " 004", " 005", " 006"});
        
        pnlCentral.add(lblPedido);
        pnlCentral.add(txtCodPedido);
        
        pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);
        
        pnlCentral.add(lbLinspector);
        pnlCentral.add(cmbinspector);
        
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
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }
    
    
    public static void main(String[] args) {
       FrmPedido Menu = new   FrmPedido();
        Menu.setVisible(true);
    }
    
    public void cargarCliente() {
        ICliente clienteDao = new  ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el cliente!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarInspector() {
        IInspector inspectorDao = new  InspectorImpl();
        try {
            lstInspector = inspectorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el inspector!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarPrestamo() {
        IPrestamo prestamoDao = new PrestamoImpl();
        try {
            lstPrestamo = prestamoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnAceptarActionListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "proceso correcto!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
    }
}
