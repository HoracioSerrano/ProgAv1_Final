package com.example.demo.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class MonedaDTO {
	private Long Id;
	private String nombre;
	@JsonManagedReference("pais-moneda")
	private List<PaisDTO> Paises;
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
	public List<PaisDTO> getPaises() {
		return Paises;
	}
	public void setPaises(List<PaisDTO> paises) {
		Paises = paises;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, Paises, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonedaDTO other = (MonedaDTO) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(Paises, other.Paises)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}
