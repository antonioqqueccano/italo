package entidad;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {

	private int idPedido;
	private Date fechaEntrega;
	private String lugarEntrega;
	private String estado;
	private int cliente;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getLugarEntrega() {
		return lugarEntrega;
	}
	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<PedidoDetalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<PedidoDetalle> detalles) {
		this.detalles = detalles;
	}
	private Ubigeo ubigeo;
	private Usuario usuario;
	private ArrayList<PedidoDetalle> detalles;
	public void setfecEnt(String fecEnt) {
		// TODO Auto-generated method stub
		
	}
	public void setFechaEntrega(String fecEnt) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
