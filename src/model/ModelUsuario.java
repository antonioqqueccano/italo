package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidad.Opcion;
import entidad.Usuario;
import util.MySqlDBConexion;
public class ModelUsuario {
public Usuario valida(String login, String clave) {
Usuario bean = null;
Connection conn = null;
PreparedStatement pstm = null;
try {
conn = MySqlDBConexion.getConexion();
String sql = "select * from usuario where login=? and password =?";
pstm = conn.prepareStatement(sql);
pstm.setString(1, login);
pstm.setString(2, clave);
System.out.println(pstm);
ResultSet rs = pstm.executeQuery();
if (rs.next()) {
bean = new Usuario();
bean.setIdUsuario(rs.getInt(1));
bean.setNombre(rs.getString("nombre"));
bean.setApellido(rs.getString("apellido"));
bean.setDni(rs.getString("dni"));
bean.setLogin(rs.getString("login"));
bean.setPassword(rs.getString("password"));
}
} catch (Exception e) {
System.out.println(e);
} finally {
try {
conn.close();
pstm.close();
} catch (SQLException e) {
}
}
return bean;
}
public int insertarUsuario(Usuario usuario) {
int response = -1;
Connection conn = null;
PreparedStatement ps = null;
try {
conn = MySqlDBConexion.getConexion();
String query = "insert into usuario values (null, ?, ?, ?, ?, ?)";
ps = conn.prepareStatement(query);
ps.setString(1, usuario.getNombre());
ps.setString(2, usuario.getApellido());
ps.setString(3, usuario.getDni());
ps.setString(4, usuario.getLogin());
ps.setString(5, usuario.getPassword());
response = ps.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
if (ps != null)
ps.close();
if (conn != null)
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
}
System.out.println(response);
return response;
}
public List<Opcion> obtieneOpciones(int idUsuario) {
ArrayList<Opcion> data = new ArrayList<Opcion>();
Opcion bean = null;
Connection conn = null;
PreparedStatement pstm = null;
try {
conn = MySqlDBConexion.getConexion();
String sql = "select p.idopcion, p.nombre from opcion pinner join rol_has_opcion r on p.idopcion = r.idopcion inner join rol c onr.idrol = c.idrol inner join usuario_has_rol h on c.idrol = h.idrol whereidusuario = ? order by 2;";
pstm = conn.prepareStatement(sql);
pstm.setInt(1, idUsuario);
System.out.println(pstm);
ResultSet rs = pstm.executeQuery();
while (rs.next()) {
bean = new Opcion();
bean.setIdOpcion(rs.getInt("idopcion"));
bean.setNombre(rs.getString("nombre"));
data.add(bean);
}
} catch (Exception e) {
System.out.println(e);
} finally {
try {
conn.close();
pstm.close();
} catch (SQLException e) {
}
}
return data;
}
//
public List<Usuario> listaUsuario() {
ArrayList<Usuario> usuario = new ArrayList<Usuario>();
Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;
try {
conn = MySqlDBConexion.getConexion();
String sql = "select * from usuario";
ps = conn.prepareStatement(sql);
rs = ps.executeQuery();
Usuario u = null;
while (rs.next()) {
u = new Usuario();
u.setIdUsuario(rs.getInt("idUsuario"));
u.setNombre(rs.getString("nombre"));
u.setApellido(rs.getString("apellido"));
u.setDni(rs.getString("dni"));
u.setLogin(rs.getString("login"));
u.setPassword(rs.getString("password"));
usuario.add(u);
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
if (ps != null)
ps.close();
if (conn != null)
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
return usuario;
}
//
public int actualizarUsuario(Usuario usuario) {
int response = -1;
Connection conn = null;
PreparedStatement ps = null;
try {
conn = MySqlDBConexion.getConexion();
String query = "UPDATE usuario SET nombre=?, apellido=?,dni=?, login=?, password=? where idusuario=?";
ps = conn.prepareStatement(query);
ps.setString(1, usuario.getNombre());
ps.setString(2, usuario.getApellido());
ps.setString(3, usuario.getDni());
ps.setString(4, usuario.getLogin());
ps.setString(5, usuario.getPassword());
ps.setInt(6, usuario.getIdUsuario());
response = ps.executeUpdate();
System.out.println("actualizados : " + response);
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
if (ps != null)
ps.close();
if (conn != null)
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
return response;
}
public int eliminarUsuario(int idUsuario) {
int response = -1;
Connection conn = null;
PreparedStatement ps = null;
try {
conn = MySqlDBConexion.getConexion();
String query = "DELETE FROM usuario WHERE idusuario=?";
ps = conn.prepareStatement(query);
ps.setInt(1, idUsuario);
response = ps.executeUpdate();
System.out.println("eliminados : " + response);
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
if (ps != null)
ps.close();
if (conn != null)
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
return response;
}
}