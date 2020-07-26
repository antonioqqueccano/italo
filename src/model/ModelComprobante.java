package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.Comprobante;
import entidad.ComprobanteDetalle;
import entidad.Pedido;
import util.MySqlDBConexion;

public class ModelComprobante {
	

	
	private static final Log log = LogFactory.getLog(ModelComprobante.class);
	
	public int inserta(Comprobante boleta) {
		log.info("---> En MySqlBoleta-> inserta");

		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm1 = null, pstm2 = null, pstm3 = null;

		try {
			conn = MySqlDBConexion.getConexion();
			// Se anula el auto envío
			conn.setAutoCommit(false);

			// se crea el sql de la cabecera
			String sql1 = "insert into boleta values(null,curtime(),?,?)";
			pstm1 = conn.prepareStatement(sql1);
			pstm1.setInt(1, boleta.getCliente().getIdCliente());
			pstm1.setInt(2, boleta.getUsuario().getIdUsuario());
			pstm1.executeUpdate();
			log.info(pstm1);
			
			// se obtiene el idBoleta insertado
			String sql2 = "select max(idBoleta) from boleta";
			pstm2 = conn.prepareStatement(sql2);
			log.info(pstm2);
			ResultSet rs = pstm2.executeQuery();
			rs.next();
			int idBoleta = rs.getInt(1);

			// se inserta el detalle de boleta
			String sql3 = "insert into boleta_has_producto values(?,?,?,?)";
			pstm3 = conn.prepareStatement(sql3);
			for (ComprobanteDetalle aux : boleta.getDetalles()) {
				pstm3.setInt(1, idBoleta);
				pstm3.setInt(2, aux.getIdProducto());
				pstm3.setDouble(3, aux.getPrecio());
				pstm3.setInt(4, aux.getCantidad());
				pstm3.executeUpdate();
				log.info(pstm3);
			}

			// se ejecuta todos los SQL en la base de datos
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				// se vuelva a un inicio
				// No permite un SQL por separado
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstm1.close();
				pstm2.close();
				pstm3.close();

			} catch (SQLException e) {
			}
		}
		return contador;
	}
}
