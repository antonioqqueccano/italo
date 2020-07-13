package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Pais;
import util.MySqlDBConexion;

public class PaisModel {
	//El metodo que va inserta enb la tabla tiporeclamo
		public int insertaPais(Pais c){
			int salida = -1;
			
			Connection con = null;
			PreparedStatement pstm  = null;
			try{
				//1 Conectar a la base de  datos
				con = MySqlDBConexion.getConexion();
				
				//2 Se prepara el SQL
				String sql = "insert into pais values(null,?,?)";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, c.getIso());
				pstm.setString(2, c.getNombre());
				System.out.println("SQL-->" + pstm);
				
				//3 envia el sql y se recibe la cantidad de registrados
				salida = pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();	
			}finally{
				try {
					if(pstm!= null)pstm.close();
					if(con!= null)con.close();
				} catch (Exception e2) {}
			}
			return salida;
		}
		
		public List<Pais> listaPais() {
			ArrayList<Pais> data = new ArrayList<Pais>();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null; //Trae la data de la BD
			try {
				con = MySqlDBConexion.getConexion();
				String sql ="select * from pais";
				pstm = con.prepareStatement(sql);
				System.out.println("SQL-->" + pstm);
				
				//En rs se trae los datos de la BD segun el SQL
				rs = pstm.executeQuery();
				
				//Se pasa la data del rs al ArrayList(data)
				Pais c = null;
				while(rs.next()){
					c = new Pais();
					c.setIdPais(rs.getInt("idpais"));
					c.setIso(rs.getString("iso"));
					c.setNombre(rs.getString("nombre"));
					data.add(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null)pstm.close();
					if (con != null)con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return data;
		}
		
		
		public int actualizaPais(Pais c) {
			int actualizados = -1;
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				con = MySqlDBConexion.getConexion();
				String sql = "update pais set iso=?, nombre=? where idpais=?"; 
				pstm = con.prepareStatement(sql);
				pstm.setString(1, c.getIso());
				pstm.setString(2, c.getNombre());
				pstm.setInt(3, c.getIdPais());
				actualizados = pstm.executeUpdate();
				System.out.println("actualizados :  " + actualizados);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null)pstm.close();
					if (con != null)con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return actualizados;
		}
		
		public int eliminaPais(int idpais) {
			int eliminados = -1;
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				con = MySqlDBConexion.getConexion();
				String sql ="delete from pais where idpais=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, idpais);
				eliminados = pstm.executeUpdate();
				System.out.println("eliminados :  " + eliminados);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null)pstm.close();
					if (con != null)con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return eliminados;
		}
}
