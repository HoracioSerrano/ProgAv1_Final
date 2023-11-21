package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AltaPersonaDTO {

		@NotBlank
		private String Apellido;
		@NotBlank
		private String Nombre;
		@NotNull
		private Integer Dni;
	    private List<DomicilioDTO> domicilios = new ArrayList<DomicilioDTO>();
	    private PaisDTO nacionalidad;

		public String getApellido() {
			return Apellido;
		}
		public void setApellido(String apellido) {
			Apellido = apellido;
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
		public List<DomicilioDTO> getDomicilios() {
			return domicilios;
		}
		public void setDomicilios(List<DomicilioDTO> domicilios) {
			this.domicilios = domicilios;
		}
		public PaisDTO getNacionalidad() {
			return nacionalidad;
		}
		public void setNacionalidad(PaisDTO nacionalidad) {
			this.nacionalidad = nacionalidad;
		}
		@Override
		public String toString() {
			return "PersonaDTO [Apellido=" + Apellido + ", Nombre=" + Nombre + ", Dni=" + Dni
					+ ", domicilios=" + domicilios + ", nacionalidad=" + nacionalidad + "]";
		}
	    
	    
	   
}
