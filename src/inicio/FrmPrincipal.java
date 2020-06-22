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
import gui.FrmCrudTipoReclamo;
import model.ModelUsuario;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements WindowListener,
		ActionListener {

	private JDesktopPane desktop = new JDesktopPane();

	//Paso 1: Agregar el formulario
	private FrmCrudTipoReclamo  frmCrudTipoReclamo = new FrmCrudTipoReclamo(); 
	
	private List<JMenuItem> listaItemMenus = new ArrayList<JMenuItem>();
	private List<JMenu> listaMenus = new ArrayList<JMenu>();
	private ModelUsuario model = new ModelUsuario();

	//Agrega el item de menu
	private JMenuItem mntmProveedor;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmTipoReclamo;
	private JMenuItem mntmPais;
	private JMenuItem mntmMarca;
	private JMenuItem mntmRol;
	private JMenuItem mntmOpcion;
	private JMenuItem mntmUbigeo;
	
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

		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setVisible(false);
		menuBar.add(mnVentas);

		mntmProveedor = new JMenuItem("Mantenimiento de proveedor");
		mntmProveedor.setVisible(false);
		mntmProveedor.addActionListener(this);
		mnAdministracin.add(mntmProveedor);
	
		mntmUsuario = new JMenuItem("Mantenimiento de usuario");
		mntmUsuario.setVisible(false);
		mntmUsuario.addActionListener(this);
		mnAdministracin.add(mntmUsuario);
		
		mntmTipoReclamo = new JMenuItem("Mantenimiento de tipo de reclamo");
		mntmTipoReclamo.setVisible(false);
		mntmTipoReclamo.addActionListener(this);
		mnAdministracin.add(mntmTipoReclamo);

		mntmPais = new JMenuItem("Mantenimiento de país");
		mntmPais.setVisible(false);
		mntmPais.addActionListener(this);
		mnAdministracin.add(mntmPais);

		mntmMarca = new JMenuItem("Mantenimiento de marca");
		mntmMarca.setVisible(false);
		mntmMarca.addActionListener(this);
		mnAdministracin.add(mntmMarca);
		
		mntmRol = new JMenuItem("Mantenimiento de rol");
		mntmRol.setVisible(false);
		mntmRol.addActionListener(this);
		mnAdministracin.add(mntmRol);
	
		
		mntmOpcion = new JMenuItem("Mantenimiento de opción");
		mntmOpcion.setVisible(false);
		mntmOpcion.addActionListener(this);
		mnAdministracin.add(mntmOpcion);
		
		
		mntmUbigeo = new JMenuItem("Mantenimiento de ubigeo");
		mntmUbigeo.setVisible(false);
		mntmUbigeo.addActionListener(this);
		mnAdministracin.add(mntmUbigeo);
		
		//Paso 2: Se añade los menus a la lista
		listaMenus.add(mnAdministracin);
		listaMenus.add(mnConsultas);
		listaMenus.add(mnVentas);
		
		//Paso 3: Se añade los items de menu a la lista
		listaItemMenus.add(mntmProveedor);
		listaItemMenus.add(mntmUsuario);
		listaItemMenus.add(mntmTipoReclamo);
		listaItemMenus.add(mntmPais);
		listaItemMenus.add(mntmMarca);
		listaItemMenus.add(mntmRol);
		listaItemMenus.add(mntmOpcion);
		listaItemMenus.add(mntmUbigeo);

		//Paso 4: Se los formularios al contenedor
		desktop.add(frmCrudTipoReclamo);
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
		int n = JOptionPane.showConfirmDialog(e.getWindow(),"¿Desea cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION);
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
		if (arg0.getSource() == mntmProveedor) {
		
		}
		if (arg0.getSource() == mntmUsuario) {
		
		}
		if (arg0.getSource() == mntmTipoReclamo) {
			centrar(frmCrudTipoReclamo);
			frmCrudTipoReclamo.setVisible(true);
		}
		if (arg0.getSource() == mntmPais) {
			
		}
		if (arg0.getSource() == mntmMarca) {
			
		}
		if (arg0.getSource() == mntmRol) {
			
		}
		if (arg0.getSource() == mntmOpcion) {
			
		}
		if (arg0.getSource() == mntmUbigeo) {
			
		}
	}
	
	
	public void muestraOpciones() {
		// Mostrar los items
		List<Opcion> data = model.obtieneOpciones(FrmLogin.idUsuario);
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

