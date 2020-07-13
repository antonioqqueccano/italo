package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmRegistraCliente extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4052159725423283753L;
	
	public FrmRegistraCliente() {
		setTitle("Registro cliente");
		setVisible(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setBounds(100, 100, 535, 471);
		getContentPane().setLayout(null);
		
	}

}
