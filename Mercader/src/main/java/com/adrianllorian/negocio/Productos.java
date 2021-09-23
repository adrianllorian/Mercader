package com.adrianllorian.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Productos {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column 
	@Range(min = 1, max = 100, message="El valor debe de estar entre 1 y 100")
	//@Size(min=5,max=1000, message="El número debe de ser entre 1 y 1000")
	//@Size(min=5, message="el nombre no puede ser pequeño")
	//@Size(max=10, message="el nombre no puede tal largo")
	private long numeroAlbaran;
	
	@Column
	private String producto;
	
	@Column 
	//@DecimalMax("1.0") @DecimalMin("1000.0") 
	private double importe;
	
	@ManyToOne
	private Tipos tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}
	

	public long getNumeroAlbaran() {
		return numeroAlbaran;
	}

	public void setNumeroAlbaran(long numeroAlbaran) {
		this.numeroAlbaran = numeroAlbaran;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", producto=" + producto + ", importe=" + importe + ", tipo=" + tipo + "]";
	}

	
	
}
