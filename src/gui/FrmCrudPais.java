package gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import entidad.Pais;
import model.ModelPais;
import util.Validaciones;
import javax.swing.ImageIcon;
public class FrmCrudPais extends JInternalFrame implements ActionListener,
MouseListener {
/**
*
*/
private static final long serialVersionUID = 1L;
private JTextField txtPais;
private JTable table;
private JButton btnAgregar;
private int selectedID = -1;
private JButton btnActualizar;
private JButton btnEliminar;
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
setBounds(100, 100, 726, 528);
getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Mantenimiento de Pais");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
lblNewLabel.setBounds(235, 24, 284, 39);
getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1_1 = new JLabel("Pais");
lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblNewLabel_1_1.setBounds(90, 117, 86, 19);
getContentPane().add(lblNewLabel_1_1);
txtPais = new JTextField();
txtPais.setBounds(201, 119, 278, 20);
getContentPane().add(txtPais);
txtPais.setColumns(10);
btnAgregar = new JButton("AGREGAR");
btnAgregar.addActionListener(this);
btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
btnAgregar.setBounds(543, 106, 115, 23);
getContentPane().add(btnAgregar);
btnActualizar = new JButton("ACTUALIZAR");
btnActualizar.addActionListener(this);
btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
btnActualizar.setBounds(543, 136, 115, 23);
getContentPane().add(btnActualizar);
btnEliminar = new JButton("ELIMINAR");
btnEliminar.addActionListener(this);
btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
btnEliminar.setBounds(543, 176, 115, 23);
getContentPane().add(btnEliminar);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(45, 226, 613, 197);
getContentPane().add(scrollPane);
table = new JTable();
table.addMouseListener(this);
table.setModel(new DefaultTableModel(
new Object[][] {
},
new String[] {
"Pais"
}
));
scrollPane.setViewportView(table);
listarPais();
}
public void actionPerformed(ActionEvent e) {
if (e.getSource() == btnEliminar) {
actionPerformedBtnEliminarJButton(e);
}
if (e.getSource() == btnActualizar) {
actionPerformedBtnActualizarJButton(e);
}
if (e.getSource() == btnAgregar) {
actionPerformedBtnAgregarJButton(e);
}
}
protected void actionPerformedBtnAgregarJButton(ActionEvent e) {
if (selectedID == -1) {

String pais = txtPais.getText();
 if (!pais.matches(Validaciones.TEXTO)) {
message("El pais debe ser entre 2 a 20 caracteres");

Pais Pais = new Pais();

Pais.setPais(pais);

ModelPais PaisModel = new ModelPais();
int response =
PaisModel.insertarPais(Pais);
if (response > 0) {
clearInputs();
listarPais();
selectedID = -1;
message("Pais insertado correctamente");
} else {
message("Error en el registro");
}
}
} else {
clearInputs();
selectedID = -1;
}
}
protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
if (selectedID == -1) {
message("Seleccione una fila");
} else {
String pais = txtPais.getText();
 if (!pais.matches(Validaciones.TEXTO)) {
message("El pais debe ser entre 2 a 20 caracteres");

Pais Pais = new Pais();
Pais.setIdPais(selectedID);
Pais.setPais(pais);
ModelPais UM = new ModelPais();
int response = UM.actualizarPais(Pais);
if (response > 0) {
clearInputs();
listarPais();
selectedID = -1;
message("Se actualizó correctamente el pais");
} else {
message("Error al actualizar el Pais");
}
}
}
}
protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
if (selectedID == -1) {
message("Debe seleccionar una fila");
} else {
ModelPais PaisModel = new ModelPais();
int response = PaisModel.eliminarPais(selectedID);
if (response > 0) {
listarPais();
clearInputs();
selectedID = -1;
message("Se eliminó correctamente el pais");
} else {
message("Error al eliminar");
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
protected void mouseClickedTableJTable(MouseEvent e) {
int row = table.getSelectedRow();
selectedID = (int) table.getValueAt(row, 0);
String pais = (String) table.getValueAt(row, 1);

txtPais.setText(pais);

}
void message(String message) {
JOptionPane.showMessageDialog(this, message);
}
void clearInputs() {
txtPais.setText("");
txtPais.requestFocus();
}
void listarPais() {
DefaultTableModel tableModel = (DefaultTableModel)
table.getModel();
tableModel.setRowCount(0);
ModelPais PaisModel = new ModelPais();
List<Pais> Paises = PaisModel.listaPais();
for (Pais Pais : Paises) {
Object[] row = { Pais.getIdPais(),
Pais.getPais() };
tableModel.addRow(row);
}
}
}