package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmRegistraComprobante extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4052159725423283753L;
	
	public FrmRegistraComprobante() {
		setTitle("Registro de comprobante");
		setVisible(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setBounds(100, 100, 535, 471);
		getContentPane().setLayout(null);
		
	}

}
