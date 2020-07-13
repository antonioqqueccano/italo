package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Pais;
import model.PaisModel;
import util.Validaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class FrmCrudPais extends JInternalFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIso;
	private JTextField txtNombre;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private int idSeleccionado = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudPais frame = new FrmCrudPais();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrudPais() {
		setTitle("Mantenimiento Pais");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 587, 346);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("                             MANTENIMIENTO DE PAIS ");
		lblTitulo.setBackground(Color.LIGHT_GRAY);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(85, 11, 414, 37);
		getContentPane().add(lblTitulo);
		
		JLabel lblIso = new JLabel("ISO");
		lblIso.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblIso.setBounds(39, 59, 46, 14);
		getContentPane().add(lblIso);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNombre.setBounds(39, 84, 60, 14);
		getContentPane().add(lblNombre);
		
		txtIso = new JTextField();
		txtIso.setBounds(109, 57, 105, 20);
		getContentPane().add(txtIso);
		txtIso.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(109, 82, 105, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(49, 130, 129, 32);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(49, 185, 129, 32);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(49, 243, 129, 32);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 59, 313, 246);
		getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idPais", "Iso", "Nombre"
			}
		));
		scrollPane.setViewportView(table);
		
		listaPais();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String iso = txtIso.getText().trim();
		String nom = txtNombre.getText().trim();
	
		if (iso.matches(Validaciones.ISO) == false){
			mensaje("La ISO es solo de 2 caracteres");
		}else if (nom.matches(Validaciones.TEXTO) == false){
			mensaje("El nombre es de 4 a 40 caracteres");
		}else{
				Pais obj = new Pais();
				obj.setIso(iso);
				obj.setNombre(nom);
				
				PaisModel model = new PaisModel();
				int salida = model.insertaPais(obj);
				if (salida>0) {
					limpiarCajasTexto();
					listaPais();
					idSeleccionado = -1;
					mensaje("Se envió correctamente");
					}else {
					mensaje("Error en el registro");
					}
		}
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		if (idSeleccionado == -1) {
			mensaje("Debe seleccionar una fila");
		}else {
			String iso = txtIso.getText().trim();
			String nom = txtNombre.getText().trim();

			if (iso.matches(Validaciones.ISO) == false){
				mensaje("La ISO es solo de 2 caracteres");
			}else if (nom.matches(Validaciones.TEXTO) == false){
				mensaje("El nombre es de 4 a 40 caracteres");
			}else{
					Pais obj = new Pais();
					obj.setIdPais(idSeleccionado);
					obj.setIso(iso);
					obj.setNombre(nom);
					
					PaisModel model = new PaisModel();
					int salida = model.actualizaPais(obj);
					if (salida>0) {
						limpiarCajasTexto();
						listaPais();
						idSeleccionado = -1;
						mensaje("Se actualizo correctamente");
						}else {
						mensaje("Error al actualizar");
						}
			}
		}
		
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		if (idSeleccionado == -1) {
			mensaje("Debe seleccionar una fila");
		}else {
			PaisModel m = new PaisModel();
			int s = m.eliminaPais(idSeleccionado);
			if ( s > 0) {
				listaPais();;
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se eliminó correctamente");
			}else {
				mensaje("Error al eliminar");
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTableJTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTableJTable(MouseEvent e) {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String iso = (String)table.getValueAt(fila, 1);
		String nom = (String)table.getValueAt(fila, 2);
		
		txtIso.setText(iso);
		txtNombre.setText(nom);

	}
	void listaPais() {
		PaisModel m = new PaisModel();
		List<Pais> data = m.listaPais();

		// Se accede a la jtable de la GUI
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		// Se coloca a sero las filas
		dtm.setRowCount(0);

		// Se agregan los campeonatos al jtable
		for (Pais aux : data) {
			Object[] fila = { aux.getIdPais(), aux.getIso(), aux.getNombre() };
			dtm.addRow(fila);
		}
	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() {
		txtIso.setText("");
		txtNombre.setText("");
		txtIso.requestFocus();
	}
}
