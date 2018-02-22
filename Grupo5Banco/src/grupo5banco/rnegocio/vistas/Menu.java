/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;

    JMenu mnDocente;
    JMenu mnEmpleado;
    JMenu mnCliente;
    JMenu mnCuenta;
    JMenu mnSucursal;
    JMenu mnInspector;

    JMenuItem mniNuevoDocente;
    JMenuItem mniModificaDocente;
    JMenuItem mniEliminaDocente;
    JMenuItem mniBuscaDocente;
    JMenuItem mniListaDocente;
    //** Empleado**
    JMenuItem mniNuevoEmpleado;
    JMenuItem mniModificaEmpleado;
    JMenuItem mniEliminaEmpleado;
    JMenuItem mniBuscaEmpleado;
    JMenuItem mniListaEmpleado;

    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;

    JMenuItem mniNuevoInspector;
    JMenuItem mniModificaInspector;
    JMenuItem mniEliminaInspector;
    JMenuItem mniBuscaInspector;
    JMenuItem mniListaInspector;
    //** sucursal**
    JMenuItem mniNuevoSucursal;
    JMenuItem mniModificaSucursal;
    JMenuItem mniEliminaSucursal;
    JMenuItem mniBuscaSucursal;
    JMenuItem mniListaSucursal;

    JDesktopPane dkpEscritorio;

    public Menu() {

        dkpEscritorio = new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));

        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        //** Empleado**
        mnEmpleado = new JMenu("Empleado");
        mniNuevoEmpleado = new JMenuItem("Nuevo");
        mniNuevoEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEmpleadoActionPerformed(e);
            }
        });
        mniModificaEmpleado = new JMenuItem("Modificar");
        mniEliminaEmpleado = new JMenuItem("Eliminar");
        mniBuscaEmpleado = new JMenuItem("Buscar");
        mniListaEmpleado = new JMenuItem("Lista");
        /////
        mnCliente = new JMenu("Cliente");
        mniNuevoCliente = new JMenuItem("Nuevo");
        mniModificaCliente = new JMenuItem("Modificar");
        mniEliminaCliente = new JMenuItem("Eliminar");
        mniBuscaCliente = new JMenuItem("Buscar");
        mniListaCliente = new JMenuItem("Lista");

        mnInspector = new JMenu("Inspector");
        mniNuevoInspector = new JMenuItem("Nuevo");
        mniModificaInspector = new JMenuItem("Modificar");
        mniEliminaInspector = new JMenuItem("Eliminar");
        mniBuscaInspector = new JMenuItem("Buscar");
        mniListaInspector = new JMenuItem("Lista");

        //** sucursal**
        mnSucursal = new JMenu("Sucursal");
        mniNuevoSucursal = new JMenuItem("Nuevo");
        mniNuevoSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoSucursalActionPerformed(e);
            }
        });
        mniModificaSucursal = new JMenuItem("Modificar");
        mniEliminaSucursal = new JMenuItem("Eliminar");
        mniBuscaSucursal = new JMenuItem("Buscar");
        mniListaSucursal = new JMenuItem("Lista");

        /////
        mnEmpleado.add(mniNuevoEmpleado);
        mnEmpleado.add(mniModificaEmpleado);
        mnEmpleado.add(mniEliminaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniBuscaEmpleado);
        mnEmpleado.add(mniListaEmpleado);

        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniModificaCliente);
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscaCliente);
        mnCliente.add(mniListaCliente);

        mnInspector.add(mniNuevoInspector);
        mnInspector.add(mniModificaInspector);
        mnInspector.add(mniEliminaInspector);
        mnInspector.addSeparator();
        mnInspector.add(mniBuscaInspector);
        mnInspector.add(mniListaInspector);

        mnSucursal.add(mniNuevoSucursal);
        mnSucursal.add(mniModificaSucursal);
        mnSucursal.add(mniEliminaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniBuscaSucursal);
        mnSucursal.add(mniListaSucursal);

        mnbPrincipal.add(mnEmpleado);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnInspector);
        mnbPrincipal.add(mnSucursal);
        mnInicio.add(mniSalir);

        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa

    }

    public void mniNuevoEmpleadoActionPerformed(ActionEvent e) {
        FmrNuevoEmpleado frm = new FmrNuevoEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoSucursalActionPerformed(ActionEvent e) {
        FrmNuevoSucursal frm = new FrmNuevoSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniNuevoPedidoActionPerformed(ActionEvent e) {
        FrmPedido frm = new FrmPedido();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        Menu frm = new Menu();
        frm.setVisible(true);
    }
}
