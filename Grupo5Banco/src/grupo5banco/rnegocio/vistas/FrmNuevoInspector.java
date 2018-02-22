package grupo5banco.rnegocio.vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import grupo5banco.rnegocio.dao.*;
import grupo5banco.rnegocio.impl.*;
import grupo5banco.rnegocio.entidades.*;

public class FrmNuevoInspector extends JInternalFrame {
    
    JLabel lblTitulo0;
    JLabel lblcodIs;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lbldireccion;
    JLabel lbltitulo;
    
    
    JTextField txtcodIs;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtdireccion;
    JTextField txttitulo;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoInspector() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del Inspector");
        
        lblcodIs= new JLabel("Codigo Inspector:");
        lblnombre= new JLabel("Nombre:");
        lblapellido= new JLabel("Apelldio:");
        lbldireccion= new JLabel("Direccion:");
        lbltitulo= new JLabel("Titulo:");
        
        txtcodIs = new JTextField(2);
        txtnombre= new JTextField(2);
        txtapellido= new JTextField(2);
        txtdireccion= new JTextField(2);
        txttitulo= new JTextField(2);
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblcodIs);
        pnlCentral.add(txtcodIs);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lbldireccion);
        pnlCentral.add(txtdireccion);
        pnlCentral.add(lbltitulo);
        pnlCentral.add(txttitulo);
        
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
        FrmNuevoInspector frmMenu= new FrmNuevoInspector();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        IInspector inspectorDao = new InspectorImpl();
        Inspector inspector = new Inspector();
        inspector.setCodIs(Integer.parseInt(txtcodIs.getText()));
        inspector.setNombre(txtnombre.getText());
        inspector.setApellido(txtapellido.getText());
        inspector.setDireccion(txtdireccion.getText());
        inspector.setTitulo(txttitulo.getText());
   
        try {
            if(inspectorDao.insertar(inspector)>0){
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
