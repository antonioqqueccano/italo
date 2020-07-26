package model;
import java.sql.PreparedStatement;

import java.sql.Connection;



import entidad.Pedido;

import util.MySqlDBConexion;

public class Modelpedido {
	
		public int RegistraPedido(Pedido p) {
			int salida= -1;
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				con=MySqlDBConexion.getConexion();
				
				
				String sql = "insert in to pedido values(null,curtime(),curtime(),?,?,?,?,?)";
				pstm =con.prepareStatement(sql);
				pstm.setDate(1, p.getFechaEntrega());;
				pstm.setString(2, p.getLugarEntrega());
				pstm.setString(3, p.getEstado());
				pstm.setInt(4,p.getCliente());
				pstm.setInt(5,p.getCliente());
				
				System.out.println("SQL-->" + pstm);
				salida = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!= null)pstm.close();
					if(con!= null)con.close();
				} catch (Exception e2) {
					}
			}
			return salida;
		}}