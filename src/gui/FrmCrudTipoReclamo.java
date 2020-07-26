package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.TipoReclamo;
import model.TipoReclamoModel;
import util.Validaciones;

public class FrmCrudTipoReclamo extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtDescripcion;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JComboBox<String> cboEstado;
	private int idSeleccionado = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudTipoReclamo frame = new FrmCrudTipoReclamo();
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
	public FrmCrudTipoReclamo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Mantenimiento de tipo de reclamo");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 625, 493);
		getContentPane().setLayout(null);

		JLabel lblMantenimientoDeTipo = new JLabel("Mantenimiento de tipo de reclamo");
		lblMantenimientoDeTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeTipo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMantenimientoDeTipo.setBounds(23, 11, 519, 41);
		getContentPane().add(lblMantenimientoDeTipo);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(112, 77, 98, 14);
		getContentPane().add(lblDescripcin);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(112, 114, 98, 14);
		getContentPane().add(lblEstado);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(239, 74, 273, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "[Seleccione]", "ACTIVO", "INACTIVO" }));
		cboEstado.setBounds(239, 114, 202, 20);
		getContentPane().add(cboEstado);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(70, 165, 129, 32);
		getContentPane().add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(223, 165, 129, 32);
		getContentPane().add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(372, 165, 129, 32);
		getContentPane().add(btnEliminar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 239, 551, 182);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Descripci\u00F3n", "Estado", "Fecha de registro" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(3).setPreferredWidth(107);
		scrollPane.setViewportView(table);

		listaTipoReclamo();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(arg0);
		}
	}

	protected void actionPerformedBtnRegistrarJButton(ActionEvent arg0) {
		String nom = txtDescripcion.getText().trim();
		int est = cboEstado.getSelectedIndex();
		String estSel = cboEstado.getSelectedItem().toString();

		if (nom.matches(Validaciones.TEXTO) == false) {
			mensaje("Nombre es de 2 a 20 caracteres");
		} else if (est == 0) {
			mensaje("Seleccione un estado");
		} else {
			TipoReclamo obj = new TipoReclamo();
			obj.setDescripcion(nom);
			obj.setEstado(estSel);

			TipoReclamoModel m = new TipoReclamoModel();
			int s = m.insertaTipoReclamo(obj);
			if (s > 0) {
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se insertó corerctamente");
				listaTipoReclamo();
			} else {
				mensaje("Error al insertar");
			}
		}

	}

	protected void actionPerformedBtnActualizarJButton(ActionEvent arg0) {
		String nom = txtDescripcion.getText().trim();
		int est = cboEstado.getSelectedIndex();
		String estSel = cboEstado.getSelectedItem().toString();
		
		if (nom.matches(Validaciones.TEXTO) == false) {
			mensaje("Nombre es de 2 a 20 caracteres");
		} else if (est == 0) {
			mensaje("Seleccione un estado");
		} else {
			TipoReclamo obj = new TipoReclamo();
			obj.setIdTipoReclamo(idSeleccionado);
			obj.setDescripcion(nom);
			obj.setEstado(estSel);
			
			TipoReclamoModel m = new TipoReclamoModel();
			int s = m.actualizaTipoReclamo(obj);
			if (s>0) {
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se actualizó corerctamente");
				listaTipoReclamo();
			}else {
				mensaje("Error al insertar");
			}
		}
	}

	protected void actionPerformedBtnEliminarJButton(ActionEvent arg0) {
		if (idSeleccionado == -1) {
			mensaje("Debe seleccionar una fila");
		}else {
			TipoReclamoModel m = new TipoReclamoModel();
			int s = m.eliminaTipoReclamo(idSeleccionado);
			if ( s > 0) {
				listaTipoReclamo();
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se eliminó correctamente");
			}else {
				mensaje("Error al eliminar");
			}
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			mouseClickedTableJTable(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	protected void mouseClickedTableJTable(MouseEvent arg0) {
		// Devuele la fila seleccionada
		int fila = table.getSelectedRow();

		idSeleccionado = Integer.parseInt(table.getValueAt(fila, 0).toString());
		String des = table.getValueAt(fila, 1).toString();
		String est = table.getValueAt(fila, 2).toString();

		txtDescripcion.setText(des);
		cboEstado.setSelectedItem(est);
	}

	void listaTipoReclamo() {
		TipoReclamoModel m = new TipoReclamoModel();
		List<TipoReclamo> data = m.listaTipoReclamos();

		// Se accede a la jtable de la GUI
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		// Se coloca a sero las filas
		dtm.setRowCount(0);

		
		for (TipoReclamo aux : data) {
			Object[] fila = { aux.getIdTipoReclamo(), aux.getDescripcion(), aux.getEstado(), aux.getFechaRegistro() };
			dtm.addRow(fila);
		}
	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() {
		txtDescripcion.setText("");
		cboEstado.setSelectedIndex(0);
		txtDescripcion.requestFocus();
	}
}
