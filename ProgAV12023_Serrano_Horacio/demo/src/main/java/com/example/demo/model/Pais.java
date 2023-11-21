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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sys_pais" )
public class Pais implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3370012436556255626L;


		
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "pai_id")
		@Id
		private Long Id;
		
		@Column(name = "pai_nombre")
		@NotBlank
		private String nombre;
		
		@Column(name = "pai_gentilicio")
		@NotBlank
		private String gentilicio;
		
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "mon_id")
		private Moneda moneda;
	    
		@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	    private List<Domicilio> domicilios = new ArrayList<Domicilio>();

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

		public Moneda getMoneda() {
			return moneda;
		}

		public void setMoneda(Moneda moneda) {
			this.moneda = moneda;
		}

		public List<Domicilio> getDomicilios() {
			return domicilios;
		}

		public void setDomicilios(List<Domicilio> domicilios) {
			this.domicilios = domicilios;
		}

		@Override
		public int hashCode() {
			return Objects.hash(Id, domicilios, gentilicio, moneda, nombre);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pais other = (Pais) obj;
			return Objects.equals(Id, other.Id) && Objects.equals(domicilios, other.domicilios)
					&& Objects.equals(gentilicio, other.gentilicio) && Objects.equals(moneda, other.moneda)
					&& Objects.equals(nombre, other.nombre);
		}
		
	    
		
	    
	    
		
		
	
}
