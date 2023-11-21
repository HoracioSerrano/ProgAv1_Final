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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "sys_persona" )
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4348558149811976652L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "per_id")
	@Id
	private Long Id;
	
	@Column(name = "per_apellido")
	@NotBlank
	private String apellido;
	
	@Column(name = "per_nombre")
	@NotBlank
	private String Nombre;
	
	@Column(name = "per_dni")
	@NotNull
	private Integer Dni;
		
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Domicilio> domicilios = new ArrayList<Domicilio>();
	
	/*

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pai_id")
    private Pais nacionalidad;
	*/
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Integer getDni() {
		return Dni;
	}
	public void setDni(Integer dni) {
		Dni = dni;
	}
	public List<Domicilio> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, Dni, Id, Nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(Dni, other.Dni)
				&& Objects.equals(Id, other.Id) && Objects.equals(Nombre, other.Nombre);
	}
	@Override
	public String toString() {
		return "Persona [Id=" + Id + ", Apellido=" + apellido + ", Nombre=" + Nombre + ", Dni=" + Dni + "]";
	}
	
	/*
	public Pais getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	*/
}
