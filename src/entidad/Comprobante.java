package entidad;

import java.sql.Date;
import java.util.ArrayList;

public class Comprobante {

	private int idComprobante;
	private Date fechaRegistro;
	private Date fechaPago;
	private String estado;
	private Pedido pedido;
	private Cliente cliente;
	private Usuario usuario;
	private ArrayList<ComprobanteDetalle> detalles;

	public ArrayList<ComprobanteDetalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<ComprobanteDetalle> detalles) {
		this.detalles = detalles;
	}
	public int getIdComprobante() {
		return idComprobante;
	}
	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
