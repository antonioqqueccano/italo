package entidad;

import java.sql.Date;

public class TipoReclamo {

	private int idTipoReclamo;
	private String descripcion;
	private String estado;
	private Date fechaRegistro;
	
	public int getIdTipoReclamo() {
		return idTipoReclamo;
	}

	public void setIdTipoReclamo(int idTipoReclamo) {
		this.idTipoReclamo = idTipoReclamo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
