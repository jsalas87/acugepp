package com.acugepp.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_lote")
public class TipoLote {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="nombre", length=100)
	private String nombre;
	@Column(name="estatus", length=1)
	private int estatus;
	
	
	
	
	public TipoLote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoLote(Integer id, String nombre, int estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	
	

}
