package inicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import entidad.Opcion;
import gui.FrmConsultaPedido;
import gui.FrmCosultaComprobante;
import gui.FrmCrudPais;
import gui.FrmCrudTipoReclamo;
import gui.FrmRegistraCliente;
import gui.FrmRegistraComprobante;
import gui.FrmRegistraPedido;
import gui.FrmRegistraProducto;
import model.UsuarioModel;
import util.DatosGlobales;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements WindowListener, ActionListener {

	private JDesktopPane desktop = new JDesktopPane();

	// Paso 1: Agregar el formulario

	// Adminsitrativa
	private FrmCrudTipoReclamo frmCrudTipoReclamo = new FrmCrudTipoReclamo();
	private FrmCrudPais frmCrudPais = new FrmCrudPais();

	// Negocio
	private FrmRegistraPedido frmRegistraPedido = new FrmRegistraPedido();
	private FrmRegistraCliente frmRegistraCliente = new FrmRegistraCliente();
	private FrmRegistraComprobante frmRegistraComprobante = new FrmRegistraComprobante();
	private FrmRegistraProducto frmRegistraProducto = new FrmRegistraProducto();

	// Consulta
	private FrmCosultaComprobante frmCosultaComprobante = new FrmCosultaComprobante();
	private FrmConsultaPedido frmConsultaPedido = new FrmConsultaPedido();

	private List<JMenuItem> listaItemMenus = new ArrayList<JMenuItem>();
	private List<JMenu> listaMenus = new ArrayList<JMenu>();
	private UsuarioModel model = new UsuarioModel();

	// Agrega el item de menu
	// Administración
	private JMenuItem mntmTipoReclamo;
	private JMenuItem mntmPais;


	// Negocio
	private JMenuItem mntmRegistroPedido;
	private JMenuItem mntmRegistroCliente;
	private JMenuItem mntmRegistroProducto;
	private JMenuItem mntmRegistroComprobante;

	// Consulta
	private JMenuItem mntmConsultaPedido;
	private JMenuItem mntmConsultaComprobante;

	public FrmPrincipal(String cad, int x, int y) {
		super(cad);
		this.setLocation(0, 0);
		this.setSize(393, 365);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);

		desktop.setSize(1000, 500);
		desktop.setBackground(new Color(116, 88, 135));

		getContentPane().add(desktop, BorderLayout.CENTER);

		addWindowListener(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		mnAdministracin.setVisible(false);
		menuBar.add(mnAdministracin);

		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setVisible(false);
		menuBar.add(mnConsultas);

		JMenu mnNegocio = new JMenu("Negocio");
		mnNegocio.setVisible(false);
		menuBar.add(mnNegocio);

		// Administrativa

		mntmTipoReclamo = new JMenuItem("Mantenimiento de tipo de reclamo");
		mntmTipoReclamo.setVisible(false);
		mntmTipoReclamo.addActionListener(this);
		mnAdministracin.add(mntmTipoReclamo);

		mntmPais = new JMenuItem("Mantenimiento de país");
		mntmPais.setVisible(false);
		mntmPais.addActionListener(this);
		mnAdministracin.add(mntmPais);

		// Negocio
		mntmRegistroPedido = new JMenuItem("Registro de pedido");
		mntmRegistroPedido.setVisible(false);
		mntmRegistroPedido.addActionListener(this);
		mnNegocio.add(mntmRegistroPedido);

		mntmRegistroComprobante = new JMenuItem("Registro de comprobante");
		mntmRegistroComprobante.setVisible(false);
		mntmRegistroComprobante.addActionListener(this);
		mnNegocio.add(mntmRegistroComprobante);

		mntmRegistroProducto = new JMenuItem("Registro de producto");
		mntmRegistroProducto.setVisible(false);
		mntmRegistroProducto.addActionListener(this);
		mnNegocio.add(mntmRegistroProducto);

		mntmRegistroCliente = new JMenuItem("Registro de cliente");
		mntmRegistroCliente.setVisible(false);
		mntmRegistroCliente.addActionListener(this);
		mnNegocio.add(mntmRegistroCliente);

		// Consultas
		mntmConsultaPedido = new JMenuItem("Consulta de pedido");
		mntmConsultaPedido.setVisible(false);
		mntmConsultaPedido.addActionListener(this);
		mnConsultas.add(mntmConsultaPedido);

		mntmConsultaComprobante = new JMenuItem("Consulta de comprobante");
		mntmConsultaComprobante.setVisible(false);
		mntmConsultaComprobante.addActionListener(this);
		mnConsultas.add(mntmConsultaComprobante);

		// Paso 2: Se añade los menus a la lista
		listaMenus.add(mnAdministracin);
		listaMenus.add(mnConsultas);
		listaMenus.add(mnNegocio);

		// Paso 3: Se añade los items de menu a la lista
		listaItemMenus.add(mntmTipoReclamo);
		listaItemMenus.add(mntmPais);
		listaItemMenus.add(mntmRegistroPedido);
		listaItemMenus.add(mntmRegistroComprobante);
		listaItemMenus.add(mntmRegistroCliente);
		listaItemMenus.add(mntmRegistroProducto);
		listaItemMenus.add(mntmConsultaComprobante);
		listaItemMenus.add(mntmConsultaPedido);

		// Paso 4: Se los formularios al contenedor
		desktop.add(frmCrudTipoReclamo);
		desktop.add(frmCrudPais);
		desktop.add(frmRegistraPedido);
		desktop.add(frmRegistraComprobante);
		desktop.add(frmRegistraCliente);
		desktop.add(frmRegistraProducto);
		desktop.add(frmConsultaPedido);
		desktop.add(frmCosultaComprobante);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");

			FrmPrincipal jf = new FrmPrincipal("Sistema de Delivery", 900, 600);
			jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			jf.setVisible(false);

			FrmLogin frm = new FrmLogin(jf);
			frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frm.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		int n = JOptionPane.showConfirmDialog(e.getWindow(), "¿Desea cerrar la aplicación?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmTipoReclamo) {
			centrar(frmCrudTipoReclamo);
			frmCrudTipoReclamo.setVisible(true);
		}
		if (arg0.getSource() == mntmPais) {
			centrar(frmCrudPais);
			frmCrudPais.setVisible(true);
		}
		if (arg0.getSource() == mntmRegistroPedido) {
			centrar(frmRegistraPedido);
			frmRegistraPedido.setVisible(true);
		}
		if (arg0.getSource() == mntmRegistroProducto) {
			centrar(frmRegistraProducto);
			frmRegistraProducto.setVisible(true);
		}
		if (arg0.getSource() == mntmRegistroCliente) {
			centrar(frmRegistraCliente);
			frmRegistraCliente.setVisible(true);
		}
		if (arg0.getSource() == mntmRegistroComprobante) {
			centrar(frmRegistraComprobante);
			frmRegistraComprobante.setVisible(true);
		}
		if (arg0.getSource() == mntmConsultaComprobante) {
			centrar(frmCosultaComprobante);
			frmCosultaComprobante.setVisible(true);
		}
		if (arg0.getSource() == mntmConsultaPedido) {
			centrar(frmConsultaPedido);
			frmConsultaPedido.setVisible(true);
		}
	}

	public void muestraOpciones() {
		// Mostrar los items
		List<Opcion> data = model.obtieneOpciones(DatosGlobales.ID_USUARIO);
		for (Opcion aux : data) {
			for (JMenuItem aux2 : listaItemMenus) {
				if (aux.getNombre().equalsIgnoreCase(aux2.getText())) {
					aux2.setVisible(true);
					break;
				}
			}
		}
		// muestra los menus
		for (JMenu aux : listaMenus) {
			verificaMenu(aux);
		}
	}

	public void verificaMenu(JMenu aux) {
		for (int i = 0; i < aux.getItemCount(); i++) {
			if (aux.getItem(i).isVisible()) {
				aux.setVisible(true);
				break;
			}
		}
	}

	public void centrar(JInternalFrame frm) {
		// Dimensiones de la pantalla
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Dimensiones del formulario
		Dimension ventana = frm.getSize();

		int posX = (int) (pantalla.getWidth() - ventana.getWidth()) / 2;
		frm.setLocation(posX, 80);
	}

}
