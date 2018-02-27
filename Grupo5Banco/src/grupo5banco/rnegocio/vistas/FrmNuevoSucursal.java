
package grupo5banco.rnegocio.vistas;

import grupo5banco.rnegocio.dao.ISucursal;
import grupo5banco.rnegocio.entidades.Sucursal;
import grupo5banco.rnegocio.impl.SucursalImpl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmNuevoSucursal extends JInternalFrame {

    JLabel lblCodSu;
    JLabel lblCiudad;
    JLabel lblTitulo0;

    JTextField txtCodSu;
    JTextField txtCiudad;

    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoSucursal() {
        this.setSize(200, 200);
        this.setLayout(new BorderLayout());
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo0 = new JLabel("Datos de la Sucursal");

        lblCodSu = new JLabel("Código:");
        lblCiudad = new JLabel("Ciudad:");

        txtCodSu = new JTextField(2);
        txtCiudad = new JTextField(2);

        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(lblCodSu);
        pnlCentral.add(txtCodSu);
        pnlCentral.add(lblCiudad);
        pnlCentral.add(txtCiudad);

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

        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
        this.setClosable(true);
    }

    public static void main(String[] args) {
        FrmNuevoSucursal frmMenu = new FrmNuevoSucursal();
        frmMenu.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {
        try {
            Sucursal sucursal = new Sucursal();
            sucursal.setCodSu(Integer.parseInt(txtCodSu.getText()));
            sucursal.setCiudad(txtCiudad.getText());
            ISucursal sucursalDao = new SucursalImpl();
            if (sucursalDao.insertar(sucursal) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error desconocido: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
