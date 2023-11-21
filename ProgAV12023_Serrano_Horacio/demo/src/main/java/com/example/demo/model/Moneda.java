package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sys_moneda")
public class Moneda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6099395305786875096L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mon_id")
	@Id
	private Long Id;
	
	@Column(name = "mon_nombre")
	@NotBlank
	private String nombre;

	@OneToMany(mappedBy = "moneda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Pais> paises = new ArrayList<Pais>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, nombre, paises);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moneda other = (Moneda) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(paises, other.paises);
	}
	
	
	
	
}
