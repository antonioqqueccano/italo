package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmConsultaPedido extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4052159725423283753L;
	
	public FrmConsultaPedido() {
		setTitle("Consulta Pedido");
		setVisible(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setBounds(100, 100, 535, 471);
		getContentPane().setLayout(null);
		
	}

}
