/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5banco.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Menu extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;

    JMenu mnEmpleado;
    JMenu mnCliente;
    JMenu mnCuenta;
    JMenu mnSucursal;
    JMenu mnInspector;
    JMenu mnPrestamo;
    JMenu mnPago;
    JMenu mnPedido;
    
    
    
    //** Empleado**
        JMenuItem mniNuevoEmpleado;
    JMenuItem mniModificaEmpleado;
    JMenuItem mniEliminaEmpleado;
    JMenuItem mniBuscaEmpleado;
    JMenuItem mniListaEmpleado;
    
    //** Cliente**
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;


    //** Pedido**
    JMenuItem mniNuevoPedido;
    JMenuItem mniModificaPedido;
    JMenuItem mniEliminaPedido;
    JMenuItem mniBuscaPedido;
    JMenuItem mniListaPedido;
    
    //** Inspector**
    JMenuItem mniNuevoInspector;
    JMenuItem mniModificaInspector;
    JMenuItem mniEliminaInspector;
    JMenuItem mniBuscaInspector;
    JMenuItem mniListaInspector;
    
    //** Prestamo**
    JMenuItem mniNuevoPrestamo;
    JMenuItem mniModificaPrestamo;
    JMenuItem mniEliminaPrestamo;
    JMenuItem mniBuscaPrestamo;
    JMenuItem mniListaPrestamo;
    
    //** Pago**
    JMenuItem mniNuevoPago;
    JMenuItem mniModificaPago;
    JMenuItem mniEliminaPago;
    JMenuItem mniBuscaPago;
    JMenuItem mniListaPago;
    
    //** Sucursal**
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
        mniBuscaEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscarEmpleadoActionPerformed(e);
            }
        });
        mniListaEmpleado = new JMenuItem("Lista");
        mniListaEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaEmpleadoActionPerformed(e);
            }
        });
        
        //** Pedido**
        mnPedido = new JMenu("Pedido");
        mniNuevoPedido = new JMenuItem("Nuevo");
        mniNuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                  mniNuevoPedidoActionPerformed(e);
            }
        });
        mniModificaPedido = new JMenuItem("Modificar");
        mniEliminaPedido = new JMenuItem("Eliminar");
        mniBuscaPedido = new JMenuItem("Buscar");
        mniListaPedido = new JMenuItem("Lista");
        mniListaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaPedidoActionPerformed(e);
            }
        });
        
        
        //** Cliente**
        mnCliente = new JMenu("Cliente");
        mniNuevoCliente = new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });
        
        mniModificaCliente = new JMenuItem("Modificar");
        mniEliminaCliente = new JMenuItem("Eliminar");
        mniBuscaCliente = new JMenuItem("Buscar");
        mniBuscaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaClienteActionPerformed(e);
            }
        });
        mniListaCliente = new JMenuItem("Listar");
        mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerformed(e);
            }
        });
        
        //** Inspector**
        mnInspector = new JMenu("Inspector");
        mniNuevoInspector = new JMenuItem("Nuevo");
        mniNuevoInspector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoInspectorActionPerformed(e);
            }
        });
        mniModificaInspector = new JMenuItem("Modificar");
        mniEliminaInspector = new JMenuItem("Eliminar");
        mniBuscaInspector = new JMenuItem("Buscar");
        mniBuscaInspector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaInspectorActionPerformed(e);
            }           
        });
        mniListaInspector = new JMenuItem("Lista");
        mniListaInspector.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                mniListaInspectorActionPerformed(e);
            }           
        });
        
        //** Prestamo**
        mnPrestamo = new JMenu("Prestamo");
        mniNuevoPrestamo = new JMenuItem("Nuevo");
        mniNuevoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPrestamoActionPerformed(e);
            }
        });
        mniModificaPrestamo = new JMenuItem("Modificar");
        mniEliminaPrestamo = new JMenuItem("Eliminar");
        mniBuscaPrestamo = new JMenuItem("Buscar");
        mniListaPrestamo = new JMenuItem("Lista");
        mniListaPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaPrestamoActionPerformed(e);
            }
        });
        
        //** Pago**
        mnPago = new JMenu("Pago");
        mniNuevoPago = new JMenuItem("Nuevo");
        mniNuevoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPagoActionPerformed(e);
            }
        });
        mniModificaPago = new JMenuItem("Modificar");
        mniEliminaPago = new JMenuItem("Eliminar");
        mniBuscaPago = new JMenuItem("Buscar");
        mniListaPago = new JMenuItem("Lista");

        
        //** Sucursal**
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
        mniBuscaSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniBuscaSucursalActionPerformed(e);
            }
        });
        mniListaSucursal = new JMenuItem("Lista");
        mniListaSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaSucursalActionPerformed(e);
            }
        });
        

        /////Empleado
        mnEmpleado.add(mniNuevoEmpleado);
        mnEmpleado.add(mniModificaEmpleado);
        mnEmpleado.add(mniEliminaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniBuscaEmpleado);
        mnEmpleado.add(mniListaEmpleado);

        /////Cliente
        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniModificaCliente);
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscaCliente);
        mnCliente.add(mniListaCliente);
        
        /////Inspector
        mnInspector.add(mniNuevoInspector);
        mnInspector.add(mniModificaInspector);
        mnInspector.add(mniEliminaInspector);
        mnInspector.addSeparator();
        mnInspector.add(mniBuscaInspector);
        mnInspector.add(mniListaInspector);

        /////Sucursal
        mnSucursal.add(mniNuevoSucursal);
        mnSucursal.add(mniModificaSucursal);
        mnSucursal.add(mniEliminaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniBuscaSucursal);
        mnSucursal.add(mniListaSucursal);
        
        /////Prestamo
        mnPrestamo.add(mniNuevoPrestamo);
        mnPrestamo.add(mniModificaPrestamo);
        mnPrestamo.add(mniEliminaPrestamo);
        mnPrestamo.addSeparator();
        mnPrestamo.add(mniBuscaPrestamo);
        mnPrestamo.add(mniListaPrestamo);
        
        /////Pago
        mnPago.add(mniNuevoPago);
        mnPago.add(mniModificaPago);
        mnPago.add(mniEliminaPago);
        mnPago.addSeparator();
        mnPago.add(mniBuscaPago);
        mnPago.add(mniListaPago);
        
        /////Pedido
        mnPedido.add(mniNuevoPedido);
        mnPedido.add(mniModificaPedido);
        mnPedido.add(mniEliminaPedido);
        mnPedido.addSeparator();
        mnPedido.add(mniBuscaPedido);
        mnPedido.add(mniListaPedido);

        /////Menu Principal
        mnbPrincipal.add(mnEmpleado);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnInspector);
        mnbPrincipal.add(mnSucursal);
        mnbPrincipal.add(mnPedido);
        mnbPrincipal.add(mnPrestamo);
        mnbPrincipal.add(mnPago);
        
        mnInicio.add(mniSalir);

        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa

    }
    
        //////CLIENTE
     public void mniNuevoClienteActionPerformed(ActionEvent e){
        FrmNuevoCliente frm = new FrmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaClienteActionPerformed(ActionEvent e){
        FrmListaCliente frm = new FrmListaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniBuscaClienteActionPerformed(ActionEvent e){
        FrmBuscarCliente frm = new FrmBuscarCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

     
        /////EMPLEADO
    public void mniNuevoEmpleadoActionPerformed(ActionEvent e) {
        FrmNuevoEmpleado frm = new FrmNuevoEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniListaEmpleadoActionPerformed(ActionEvent e) {
        FrmListaEmpleado frm = new FrmListaEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniBuscarEmpleadoActionPerformed(ActionEvent e) {
        FrmBuscarEmpleado frm = new FrmBuscarEmpleado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    
      //////SUCURSAL
    public void mniNuevoSucursalActionPerformed(ActionEvent e) {
        FrmNuevoSucursal frm = new FrmNuevoSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaSucursalActionPerformed(ActionEvent e) {
        FrmListaSucursal frm = new FrmListaSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniBuscaSucursalActionPerformed(ActionEvent e) {
        FrmBuscarSucursal frm = new FrmBuscarSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
        /////PEDIDO
    public void mniNuevoPedidoActionPerformed(ActionEvent e) {
        FrmNuevoPedido frm = new FrmNuevoPedido();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniListaPedidoActionPerformed(ActionEvent e) {
        FrmListaPedido frm = new FrmListaPedido();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
        /////PRESTAMO
    public void mniNuevoPrestamoActionPerformed(ActionEvent e) {
        FrmNuevoPrestamo frm = new FrmNuevoPrestamo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniListaPrestamoActionPerformed(ActionEvent e) {
        FrmListaPrestamo frm = new FrmListaPrestamo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
        /////PAGO
    public void mniNuevoPagoActionPerformed(ActionEvent e) {
        FrmNuevoPago frm = new FrmNuevoPago();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniListaPagoActionPerformed(ActionEvent e) {
        FrmListaPago frm = new FrmListaPago();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
        /////INSPECTOR
    public void mniNuevoInspectorActionPerformed(ActionEvent e){
        FrmNuevoInspector frm = new FrmNuevoInspector();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaInspectorActionPerformed(ActionEvent e){
        FrmListaInspector frm = new FrmListaInspector();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
        }
    public void mniBuscaInspectorActionPerformed(ActionEvent e){
        FrmBuscarInspector frm = new FrmBuscarInspector();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        Menu frm = new Menu();
        frm.setVisible(true);
    }
}
