package com.adrianllorian.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tipos {

	@Id
	private Integer id;
	
	@Column
	private String tipo;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="tipo")
	private List <Productos> productos;
	
	
	public Tipos() {}
	
	public Tipos(Integer id, String tipo) {
		this.id = id;
		this.tipo = tipo;
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	
	
	
}
