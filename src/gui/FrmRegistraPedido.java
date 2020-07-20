package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import componentes.JComboBoxBD;
import entidad.Comprobante;
import entidad.ComprobanteDetalle;
import entidad.Cliente;
import entidad.Usuario;
import model.ModelComprobante;


@SuppressWarnings("serial")
public class FrmRegistraPedido extends JInternalFrame{
	private JLabel jLabel1;
	private JComboBoxBD cboCliente;
	private JPanel jPanel1;
	private JComboBoxBD cboProducto;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JButton btnCancelarBoleta;
	private JButton btnRegistraBoleta;
	private JTable jTable1;
	private JButton btnLimpiar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JTextField txtCantidad;
	private JLabel jLabel2;
	private JPanel jPanel2;
	private DefaultTableModel jTable1Model;
	private JTextField txtPrecio;
	private JLabel jLabel4;
	
	private JLabel lblIGVSalidas;
	private JLabel lblTotalSalidas;
	private JLabel lblSubTotalSalidas;

	
	
	private ResourceBundle rb = ResourceBundle.getBundle("combo");
	private static final long serialVersionUID = 4052159725423283753L;

	ModelComprobante model = new ModelComprobante();
	
	public FrmRegistraPedido() {
		this.setTitle("Registro de pedido");
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(100, 100, 606, 617);
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
			
	 	getContentPane().setLayout(null);

	 	jPanel1 = new JPanel();
	 	getContentPane().add(jPanel1);
	 	jPanel1.setLayout(null);
	 	jPanel1.setBounds(19, 11, 568, 56);
	 	jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Cabecera", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0,0,255)));

	 	jPanel2 = new JPanel();
	 	getContentPane().add(jPanel2);
	 	jPanel2.setBounds(19, 86, 568, 449);
	 	jPanel2.setLayout(null);
	 	jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0,0,255)));

	 	btnRegistraBoleta = new JButton();
	 	getContentPane().add(btnRegistraBoleta);
	 	btnRegistraBoleta.setText("Registra Boleta");
	 	btnRegistraBoleta.setBounds(19, 545, 268, 32);
	 	btnRegistraBoleta.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			btnRegistraBoletaActionPerformed(evt);
	 		}
	 	});

	 	btnCancelarBoleta = new JButton();
	 	getContentPane().add(btnCancelarBoleta);
	 	btnCancelarBoleta.setText("Cancelar");
	 	btnCancelarBoleta.setBounds(298, 546, 289, 30);
	 	btnCancelarBoleta.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			btnCancelarBoletaActionPerformed(evt);
	 		}
	 	});

	 	jLabel2 = new JLabel();
	 	jPanel2.add(jLabel2);
	 	jLabel2.setText("Producto");
	 	jLabel2.setBounds(29, 28, 146, 26);

	 	
	 	cboProducto = new JComboBoxBD(rb.getString("SQL_COMBO_PRODUCTO"));
	 	jPanel2.add(cboProducto);
	 	cboProducto.setBounds(193, 30, 211, 23);
	 	cboProducto.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			cboProductoActionPerformed(evt);
	 		}
	 	});
	 	
	 	
	 	jLabel3 = new JLabel();
	 	jPanel2.add(jLabel3);
	 	jLabel3.setText("Cantidad");
	 	jLabel3.setBounds(29, 65, 146, 23);

	 	txtCantidad = new JTextField();
	 	jPanel2.add(txtCantidad);
	 	txtCantidad.setBounds(193, 64, 211, 23);

	 	btnAgregar = new JButton();
	 	jPanel2.add(btnAgregar);
	 	btnAgregar.setText("Agregar");
	 	btnAgregar.setBounds(442, 23, 99, 30);
	 	btnAgregar.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			btnAgregarActionPerformed(evt);
	 		}
	 	});

	 	btnEliminar = new JButton();
	 	jPanel2.add(btnEliminar);
	 	btnEliminar.setText("Eliminar");
	 	btnEliminar.setBounds(442, 64, 99, 31);
	 	btnEliminar.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			btnEliminarActionPerformed(evt);
	 		}
	 	});

	 	btnActualizar = new JButton();
	 	jPanel2.add(btnActualizar);
	 	btnActualizar.setText("Actualizar");
	 	btnActualizar.setBounds(442, 106, 99, 32);
	 	btnActualizar.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			btnActualizarActionPerformed(evt);
	 		}
	 	});

	 	btnLimpiar = new JButton();
	 	jPanel2.add(btnLimpiar);
	 	btnLimpiar.setText("Limpiar");
	 	btnLimpiar.setBounds(442, 149, 99, 29);
	 	btnLimpiar.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent evt) {
	 			btnLimpiarActionPerformed(evt);
	 		}
	 	});

	 	jScrollPane1 = new JScrollPane();
	 	jPanel2.add(jScrollPane1);
	 	jScrollPane1.setBounds(29, 188, 512, 136);

	 	jLabel4 = new JLabel();
	 	jPanel2.add(jLabel4);
	 	jLabel4.setText("Precio");
	 	jLabel4.setBounds(29, 98, 96, 23);

	 	txtPrecio = new JTextField();
	 	jPanel2.add(txtPrecio);
	 	txtPrecio.setBounds(193, 98, 211, 23);

	 	 jTable1Model = 
	 			new DefaultTableModel(
	 					new String[][] { },
	 					new String[] { "ID","Producto", "Cantidad", "Precio", "Subtotal" }){
	 		 
	 		 @Override
	 		public boolean isCellEditable(int row, int column) {
	 		
	 			 return false;
	 		}
	 	 };
	 
	 	 
	 	jTable1 = new JTable();
	 	jScrollPane1.setViewportView(jTable1);
	 	jTable1.setModel(jTable1Model);
	 	
	 	JLabel lblTotal = new JLabel("Sub Total");
	 	lblTotal.setBounds(317, 349, 104, 26);
	 	jPanel2.add(lblTotal);
	 	
	 	JLabel lblIgv = new JLabel("IGV");
	 	lblIgv.setBounds(317, 378, 104, 26);
	 	jPanel2.add(lblIgv);
	 	
	 	JLabel lblTotal_1 = new JLabel("Total");
	 	lblTotal_1.setBounds(317, 406, 104, 26);
	 	jPanel2.add(lblTotal_1);
	 	
	 	lblIGVSalidas = new JLabel("");
	 	lblIGVSalidas.setFont(new Font("Tahoma", Font.BOLD, 11));
	 	lblIGVSalidas.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblIGVSalidas.setOpaque(true);
	 	lblIGVSalidas.setBackground(Color.LIGHT_GRAY);
	 	lblIGVSalidas.setBounds(442, 378, 99, 26);
	 	jPanel2.add(lblIGVSalidas);
	 	
	 	lblSubTotalSalidas = new JLabel("");
	 	lblSubTotalSalidas.setFont(new Font("Tahoma", Font.BOLD, 11));
	 	lblSubTotalSalidas.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblSubTotalSalidas.setOpaque(true);
	 	lblSubTotalSalidas.setBackground(Color.LIGHT_GRAY);
	 	lblSubTotalSalidas.setBounds(442, 350, 99, 26);
	 	jPanel2.add(lblSubTotalSalidas);
	 	
	 	lblTotalSalidas = new JLabel("");
	 	lblTotalSalidas.setFont(new Font("Tahoma", Font.BOLD, 11));
	 	lblTotalSalidas.setHorizontalAlignment(SwingConstants.CENTER);
	 	lblTotalSalidas.setOpaque(true);
	 	lblTotalSalidas.setBackground(Color.LIGHT_GRAY);
	 	lblTotalSalidas.setBounds(442, 406, 99, 26);
	 	jPanel2.add(lblTotalSalidas);
	 	
	 	JTextArea textArea = new JTextArea();
	 	textArea.setBounds(238, 29, 4, 22);
	 	jPanel2.add(textArea);
	 
	 	
	 	jLabel1 = new JLabel();
	 	jPanel1.add(jLabel1);
	 	jLabel1.setText("Cliente");
	 	jLabel1.setBounds(32, 23, 134, 24);

	 	cboCliente = new JComboBoxBD(rb.getString("SQL_COMBO_CLIENTE")); 
	 	jPanel1.add(cboCliente);
	 	cboCliente.setBounds(192, 23, 354, 25);
	}
	
	private void cboProductoActionPerformed(ActionEvent evt){
		String opcion = cboProducto.getSelectedItem().toString().trim();
		
		
		if(opcion.equals("[seleccione]")){
			txtPrecio.setText("");
		}else{
			String[] sep = opcion.split(":");
			txtPrecio.setText(sep[2]);
		}
	}
	
	
	private void btnAgregarActionPerformed(ActionEvent evt) {
			if(cboProducto.getSelectedIndex() ==0){
				JOptionPane.showMessageDialog(this, "Seleccione un producto");
				return;
			}
			if(!txtCantidad.getText().trim().matches("\\d{1,4}")){
				JOptionPane.showMessageDialog(this, "La cantidad es número dos dígitos");
				return;
			}
			if(!txtPrecio.getText().trim().matches("(\\d+.\\d{1})|(\\d+)")){
				JOptionPane.showMessageDialog(this, "El precio es ##.# ó ##");
				return;
			}
			
			String Pro = cboProducto.getSelectedItem().toString().trim();			
			int cantidad = Integer.parseInt(txtCantidad.getText().trim());
			double precio = Double.parseDouble(txtPrecio.getText().trim());   

	
			String idProducto = Pro.split(":")[0];
			String nombre = Pro.split(":")[1];
			
		
			String idAux = null;
			boolean noExiste = true;
			for (int i = 0; i < jTable1Model.getRowCount(); i++) {
				idAux = (String)jTable1Model.getValueAt(i, 0);
				if(idAux.equals(idProducto)){
					 noExiste = false;
					 break;
				}
			}
		
			if(noExiste){
				Object[] fila = {idProducto, nombre, cantidad, precio, cantidad*precio};
				jTable1Model.addRow(fila);
			}else{
				JOptionPane.showMessageDialog(this, "El producto ya ha sido seleccionado"); 
			}
			
			calculaTotales();

	}
	
	private void btnEliminarActionPerformed(ActionEvent evt) {
		int fila = jTable1.getSelectedRow();
		if(fila == -1){
			JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
		}else{
			jTable1Model.removeRow(fila);
			calculaTotales();
		}
	}
	
	private void btnActualizarActionPerformed(ActionEvent evt) {
		if(cboProducto.getSelectedIndex() ==0){
			JOptionPane.showMessageDialog(this, "Seleccione un producto");
			return;
		}
		if(!txtCantidad.getText().trim().matches("\\d{1,4}")){
			JOptionPane.showMessageDialog(this, "La cantidad es número de dos dígitos");
			return;
		}
		if(!txtPrecio.getText().trim().matches("(\\d+.\\d{1})|(\\d+)")){
			JOptionPane.showMessageDialog(this, "El precio es ##.# ó ##");
			return;
		}
		String prod = cboProducto.getSelectedItem().toString().trim();			
		int cantidad = Integer.parseInt(txtCantidad.getText().trim());
		double precio = Double.parseDouble(txtPrecio.getText().trim());   
		
		String idProducto = prod.split(":")[0];
		
		String idAux = null;
		for (int i = 0; i < jTable1Model.getRowCount(); i++) {
			idAux = (String)jTable1Model.getValueAt(i, 0);
			if(idAux.equals(idProducto)){
				jTable1Model.setValueAt(cantidad, i, 2);
				jTable1Model.setValueAt(precio, i, 3);
				jTable1Model.setValueAt(precio*cantidad, i, 4);
			}
		}
		
		calculaTotales();
	}
	
	public void calculaTotales(){
		double subTotal = 0;
		for (int i = 0; i < jTable1Model.getRowCount(); i++) {
			subTotal+= (Double)jTable1Model.getValueAt(i, 4);
		}
		
		double igv = 0.18 * subTotal;
		double total = subTotal + igv;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		lblSubTotalSalidas.setText(df.format(subTotal));
		lblIGVSalidas.setText(df.format(igv));
		lblTotalSalidas.setText(df.format(total));
	}	
	
	private void btnLimpiarActionPerformed(ActionEvent evt) {
		limpiarb();

	}
	
	private void btnRegistraBoletaActionPerformed(ActionEvent evt) {
		
		if(cboCliente.getSelectedIndex() ==0){
			JOptionPane.showMessageDialog(this, "Seleccione un cliente");
			return;
		}
		
		if( jTable1Model.getRowCount() ==0){
			JOptionPane.showMessageDialog(this, "No existe productos");
			return;
		}
		
	
		String cliente = cboCliente.getSelectedItem().toString();
		String[] sep = cliente.split(":");
		int idCliente = Integer.parseInt(sep[0]);
		

		Cliente objCli = new Cliente();
		objCli.setIdCliente(idCliente);

		Usuario objUsu = new Usuario();
		objUsu.setIdUsuario(1);
		
	
		ComprobanteDetalle aux = null;
		ArrayList<ComprobanteDetalle> detalles = new ArrayList<ComprobanteDetalle>();
		
		for (int i = 0; i < jTable1Model.getRowCount(); i++) {
			aux = new ComprobanteDetalle();
			
			String prod = jTable1Model.getValueAt(i, 1).toString();
			aux.setIdProducto(Integer.parseInt(prod));
		
			String cant = jTable1Model.getValueAt(i, 2).toString();
			aux.setCantidad(Integer.parseInt(cant));
			
			String precio = jTable1Model.getValueAt(i, 3).toString();
			
			aux.setPrecio(Double.parseDouble(precio));
			
			detalles.add(aux);
		}
		
		
		
		Comprobante objBol = new Comprobante();
		objBol.setUsuario(objUsu);
		objBol.setCliente(objCli);
		objBol.setDetalles(detalles);
		
		
		model.inserta(objBol);
		
		
		limpiar();
		JOptionPane.showMessageDialog(this, "Se inserto correctamente");	
	}
	
	private void btnCancelarBoletaActionPerformed(ActionEvent evt) {
		limpiar();
	}
	
	
	void limpiarb() {
		txtCantidad.setText("");
		txtPrecio.setText("");
		cboProducto.setSelectedIndex(0);
		cboCliente.setSelectedIndex(0);
		cboCliente.requestFocus();
	}
	void limpiar(){
		txtCantidad.setText("");
		txtPrecio.setText("");
		cboProducto.setSelectedIndex(0);
		cboCliente.setSelectedIndex(0);
		jTable1Model.setRowCount(0);
		cboCliente.requestFocus();
		
		lblSubTotalSalidas.setText("");
		lblIGVSalidas.setText("");
		lblTotalSalidas.setText("");
	}
}

