package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;

public class DomicilioDTO {

	private Long id;
	private String calle;
	private Integer altura;
	@JsonBackReference("persona-domiclio")
    private PersonaDTO persona;
	@JsonBackReference("domicilio-pais")
    private PaisDTO pais;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	public PaisDTO getPais() {
		return pais;
	}
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
	
	
    
    
}
