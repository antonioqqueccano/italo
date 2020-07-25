package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.mysql.jdbc.Statement;

import componentes.JComboBoxBD;
import entidad.Cliente;
import entidad.Comprobante;
import entidad.ComprobanteDetalle;
import entidad.Pedido;
import entidad.TipoReclamo;
import entidad.Usuario;
import model.ModelComprobante;
import model.TipoReclamoModel;
import util.Validaciones;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;




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
	
	private JLabel SubTotal;
	private JLabel Total;
	private JLabel Igv;

	
	
	private ResourceBundle rb = ResourceBundle.getBundle("combo");
	private static final long serialVersionUID = 4052159725423283753L;

	ModelComprobante model = new ModelComprobante();
	private JTextField txtFecEn;
	private JTextField txtLugEnt;
	private JComboBox<String> cboEstado;
	private JLabel lblNewLabel_2;
	private int idCliente =-1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistraPedido frame = new FrmRegistraPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public FrmRegistraPedido() {
		this.setTitle("Registro de pedido");
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(100, 100, 896, 617);
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
	 	jPanel2.setBounds(10, 85, 860, 449);
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
	 	btnCancelarBoleta.setBounds(529, 546, 289, 30);
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
	 	cboProducto.setBounds(105, 30, 211, 23);
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
	 	txtCantidad.setBounds(105, 65, 211, 23);

	 	jScrollPane1 = new JScrollPane();
	 	jPanel2.add(jScrollPane1);
	 	jScrollPane1.setBounds(10, 208, 840, 136);

	 	jLabel4 = new JLabel();
	 	jPanel2.add(jLabel4);
	 	jLabel4.setText("Precio");
	 	jLabel4.setBounds(29, 98, 96, 23);

	 	txtPrecio = new JTextField();
	 	jPanel2.add(txtPrecio);
	 	txtPrecio.setBounds(105, 98, 211, 23);

	 	 jTable1Model = 
	 			new DefaultTableModel(
	 					new String[][] { },
	 					new String[] { "ID","Producto", "Cantidad", "Precio","entrega","Lugar de entrega","estado", "Subtotal" }){
	 		 
	 		 @Override
	 		public boolean isCellEditable(int row, int column) {
	 		
	 			 return false;
	 		}
	 	 };
	 
	 	 
	 	jTable1 = new JTable();
	 	jScrollPane1.setViewportView(jTable1);
	 	jTable1.setModel(jTable1Model);
	 	
	 	JLabel lblTotal = new JLabel("Sub Total");
	 	lblTotal.setBounds(522, 378, 104, 26);
	 	jPanel2.add(lblTotal);
	 	
	 	JLabel lblIgv = new JLabel("IGV");
	 	lblIgv.setBounds(631, 378, 104, 26);
	 	jPanel2.add(lblIgv);
	 	
	 	JLabel lblTotal_1 = new JLabel("Total");
	 	lblTotal_1.setBounds(751, 378, 104, 26);
	 	jPanel2.add(lblTotal_1);
	 	
	 	SubTotal = new JLabel("");
	 	SubTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
	 	SubTotal.setHorizontalAlignment(SwingConstants.CENTER);
	 	SubTotal.setOpaque(true);
	 	SubTotal.setBackground(Color.LIGHT_GRAY);
	 	SubTotal.setBounds(522, 406, 99, 26);
	 	jPanel2.add(SubTotal);
	 	
	 	Igv = new JLabel("");
	 	Igv.setFont(new Font("Tahoma", Font.BOLD, 11));
	 	Igv.setHorizontalAlignment(SwingConstants.CENTER);
	 	Igv.setOpaque(true);
	 	Igv.setBackground(Color.LIGHT_GRAY);
	 	Igv.setBounds(631, 406, 99, 26);
	 	jPanel2.add(Igv);
	 	
	 	Total = new JLabel("");
	 	Total.setFont(new Font("Tahoma", Font.BOLD, 11));
	 	Total.setHorizontalAlignment(SwingConstants.CENTER);
	 	Total.setOpaque(true);
	 	Total.setBackground(Color.LIGHT_GRAY);
	 	Total.setBounds(751, 406, 99, 26);
	 	jPanel2.add(Total);
	 	
	 	JTextArea textArea = new JTextArea();
	 	textArea.setBounds(238, 29, 4, 22);
	 	jPanel2.add(textArea);
	 	
	 		 	btnLimpiar = new JButton();
	 		 	btnLimpiar.setBounds(673, 108, 99, 29);
	 		 	jPanel2.add(btnLimpiar);
	 		 	btnLimpiar.setText("Limpiar");
	 		 	
	 		 		 	btnActualizar = new JButton();
	 		 		 	btnActualizar.setBounds(673, 42, 99, 32);
	 		 		 	jPanel2.add(btnActualizar);
	 		 		 	btnActualizar.setText("Actualizar");
	 		 		 	
	 		 		 		 	btnEliminar = new JButton();
	 		 		 		 	btnEliminar.setBounds(673, 11, 99, 31);
	 		 		 		 	jPanel2.add(btnEliminar);
	 		 		 		 	btnEliminar.setText("Eliminar");
	 		 		 		 	
	 		 		 		 		 	btnAgregar = new JButton();
	 		 		 		 		 	btnAgregar.setBounds(673, 76, 99, 30);
	 		 		 		 		 	jPanel2.add(btnAgregar);
	 		 		 		 		 	btnAgregar.setText("Agregar");
	 		 		 		 		 	
	 		 		 		 		 	JLabel lblNewLabel = new JLabel("fecha de entrega");
	 		 		 		 		 	lblNewLabel.setBounds(343, 34, 96, 14);
	 		 		 		 		 	jPanel2.add(lblNewLabel);
	 		 		 		 		 	
	 		 		 		 		 	txtFecEn = new JTextField();
	 		 		 		 		 	txtFecEn.setBounds(442, 31, 155, 20);
	 		 		 		 		 	jPanel2.add(txtFecEn);
	 		 		 		 		 	txtFecEn.setColumns(10);
	 		 		 		 		 	
	 		 		 		 		 	JLabel lblNewLabel_1 = new JLabel("Lugar entrega\r\n");
	 		 		 		 		 	lblNewLabel_1.setBounds(343, 69, 96, 14);
	 		 		 		 		 	jPanel2.add(lblNewLabel_1);
	 		 		 		 		 	
	 		 		 		 		 	txtLugEnt = new JTextField();
	 		 		 		 		 	txtLugEnt.setBounds(442, 66, 155, 20);
	 		 		 		 		 	jPanel2.add(txtLugEnt);
	 		 		 		 		 	txtLugEnt.setColumns(10);
	 		 		 		 		 	
	 		 		 		 		 	cboEstado = new JComboBox<String>();
	 		 		 		 		 	cboEstado.setModel(new DefaultComboBoxModel(new String[] {"[Seleccione]", "ACTIVO", "INACTIVO"}));
	 		 		 		 		 	cboEstado.setBounds(442, 99, 155, 20);
	 		 		 		 		 	jPanel2.add(cboEstado);
	 		 		 		 		 	
	 		 		 		 		 	lblNewLabel_2 = new JLabel("Estado\r\n");
	 		 		 		 		 	lblNewLabel_2.setBounds(343, 102, 46, 14);
	 		 		 		 		 	jPanel2.add(lblNewLabel_2);
	 		 		 		 		 	btnAgregar.addActionListener(new ActionListener() {
	 		 		 		 		 		public void actionPerformed(ActionEvent evt) {
	 		 		 		 		 			btnAgregarActionPerformed(evt);
	 		 		 		 		 		}
	 		 		 		 		 	});
	 		 		 		 	btnEliminar.addActionListener(new ActionListener() {
	 		 		 		 		public void actionPerformed(ActionEvent evt) {
	 		 		 		 			btnEliminarActionPerformed(evt);
	 		 		 		 		}
	 		 		 		 	});
	 		 		 	btnActualizar.addActionListener(new ActionListener() {
	 		 		 		public void actionPerformed(ActionEvent evt) {
	 		 		 			btnActualizarActionPerformed(evt);
	 		 		 		}
	 		 		 	});
	 		 	btnLimpiar.addActionListener(new ActionListener() {
	 		 		public void actionPerformed(ActionEvent evt) {
	 		 			btnLimpiarActionPerformed(evt);
	 		 		}
	 		 	});
	 
	 	
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
			}if(!txtFecEn.getText().trim().matches(Validaciones.FECHA)){
				JOptionPane.showMessageDialog(this, "fecha:yyyy-mm-dd");
				return;
			}if(!txtLugEnt.getText().trim().matches(Validaciones.TEXTO)){
				JOptionPane.showMessageDialog(this, "Colocar lugar de entrega");
				return;
			}if(cboEstado.getSelectedIndex() ==0){
				JOptionPane.showMessageDialog(this, "Seleccione el estado");
				return;}
			
			
			String Pro = cboProducto.getSelectedItem().toString().trim();
			int cantidad = Integer.parseInt(txtCantidad.getText().trim());
			double precio = Double.parseDouble(txtPrecio.getText().trim());
			String fecEnt= txtFecEn.getText().trim();
		    String lugEnt=txtLugEnt.getText().trim();
		    String est=cboEstado.getSelectedItem().toString().trim();
			
			

	
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
				Object[] fila = {idProducto, nombre, cantidad, precio,fecEnt,lugEnt,est, cantidad*precio};
				jTable1Model.addRow(fila);
			}else{
				JOptionPane.showMessageDialog(this, "El producto ya ha sido seleccionado"); 
			}
			
			calculaTotal();

	}
	
	private void btnEliminarActionPerformed(ActionEvent evt) {
		int fila = jTable1.getSelectedRow();
		if(fila == -1){
			JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
		}else{
			jTable1Model.removeRow(fila);
			calculaTotal();
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
		}if(!txtFecEn.getText().trim().matches(Validaciones.FECHA)){
			JOptionPane.showMessageDialog(this, "fecha:yyyy-mm-dd");
			return;
		}if(!txtLugEnt.getText().trim().matches(Validaciones.TEXTO)){
			JOptionPane.showMessageDialog(this, "Colocar lugar de entrega");
			return;
		}
		
		String prod = cboProducto.getSelectedItem().toString().trim();			
		int cantidad = Integer.parseInt(txtCantidad.getText().trim());
		double precio = Double.parseDouble(txtPrecio.getText().trim()); 
		String fecEnt= txtFecEn.getText().trim();
	    String lugEnt=txtLugEnt.getText().trim();
		
		
		String idProducto = prod.split(":")[0];
		
		
		
		String idAux = null;
		for (int i = 0; i < jTable1Model.getRowCount(); i++) {
			idAux = (String)jTable1Model.getValueAt(i, 0);
			if(idAux.equals(idProducto)){
				jTable1Model.setValueAt(cantidad, i, 2);
				jTable1Model.setValueAt(precio, i, 3);
				jTable1Model.setValueAt(fecEnt, i, 4);
				jTable1Model.setValueAt(lugEnt, i, 5);
				jTable1Model.setValueAt(precio*cantidad, i, 6);
				
			}
			calculaTotal();
		}}
		
		
	
	
	public void calculaTotal(){
		double subTotal = 0;
		for (int i = 0; i < jTable1Model.getRowCount(); i++) {
			subTotal+= (Double)jTable1Model.getValueAt(i, 4);
		}
		
		double igv = 0.18 * subTotal;
		double total = subTotal + igv;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		Igv.setText(df.format(subTotal));
		SubTotal.setText(df.format(igv));
		Total.setText(df.format(total));
	}	
	
	private void btnLimpiarActionPerformed(ActionEvent evt) {
		limpiarb();

	}
	
	private void btnRegistraBoletaActionPerformed(ActionEvent evt) {

		String fecEnt= txtFecEn.getText().trim();
		String lugEnt=txtLugEnt.getText().trim();
		int est = cboEstado.getSelectedIndex();
		String estSel = cboEstado.getSelectedItem().toString();
		int cli=cboCliente.getSelectedIndex();
		
		if(fecEnt.matches(Validaciones.FECHA)==false) {
			JOptionPane.showMessageDialog(this, "fecha:yyyy-mm-dd");
		}else if(lugEnt.matches(Validaciones.TEXTO)==false) {
			JOptionPane.showMessageDialog(this, "Colocar lugar de entrega");
		}else if (est == 0) {
			JOptionPane.showMessageDialog(this,"Seleccione un estado");
		} else {
			Pedido obj = new Pedido();
			obj.setFechaEntrega(fecEnt);
			obj.setLugarEntrega(lugEnt);
			obj.setEstado(estSel);
			obj.setCliente(cli);

			ModelComprobante m = new ModelComprobante();
			int s = m.Registrar(obj);
			if (s > 0) {
				idCliente = -1;
				limpiar();
				JOptionPane.showMessageDialog(this, "Se registro corerctamente");
				
			} else {
				JOptionPane.showMessageDialog(this, "error al registrar");
			}
		
		}
	}
		

	
	private void btnCancelarBoletaActionPerformed(ActionEvent evt) {
		limpiar();
	}
	
	
	void limpiarb() {
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtFecEn.setText("");
		txtLugEnt.setText("");
		cboProducto.setSelectedIndex(0);
		cboCliente.setSelectedIndex(0);
		cboCliente.requestFocus();
	}
	void limpiar(){
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtFecEn.setText("");
		txtLugEnt.setText("");
		cboProducto.setSelectedIndex(0);
		cboCliente.setSelectedIndex(0);
		jTable1Model.setRowCount(0);
		cboCliente.requestFocus();
		
		Igv.setText("");
		SubTotal.setText("");
		Total.setText("");
	}
}

