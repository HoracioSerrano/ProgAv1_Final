package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class PaisDTO {
	

	private Long Id;
	private String nombre;
	private String gentilicio;
	@JsonBackReference("pais-moneda")
	private MonedaDTO moneda;
	@JsonManagedReference("domicilio-pais")
	private List<DomicilioDTO> domicilios;
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
	public String getGentilicio() {
		return gentilicio;
	}
	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}
	public MonedaDTO getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaDTO moneda) {
		this.moneda = moneda;
	}
	public List<DomicilioDTO> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(List<DomicilioDTO> domicilios) {
		this.domicilios = domicilios;
	}
	

    
    
    
}
