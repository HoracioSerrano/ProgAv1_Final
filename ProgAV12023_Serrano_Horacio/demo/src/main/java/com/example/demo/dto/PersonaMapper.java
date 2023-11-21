package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Domicilio;
import com.example.demo.model.Persona;

@Component
public class PersonaMapper {
	@Autowired
	DomicilioMapper domicilioMapper;
//	@Autowired
//	PaisMapper paisMapper;
	
	
	public Persona dtoToEntity(PersonaDTO dto) {
		Persona entity = new Persona();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setDni(dto.getDni());
		entity.setDomicilios(domicilioMapper.lstDtoToEntity(dto.getDomicilios()));
		for(Domicilio dom : entity.getDomicilios()) {
			dom.setPersona(entity);
		}		
		//entity.setNacionalidad(paisMapper.dtoToEntity(dto.getNacionalidad()));
		entity.setNombre(dto.getNombre());
		return entity;
	}
	
	public PersonaDTO entityToDto(Persona entity) {
		PersonaDTO dto = new PersonaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());		
		dto.setDni(entity.getDni());
		dto.setDomicilios(domicilioMapper.lstEntityToLstDto(entity.getDomicilios()));
		for(DomicilioDTO d : dto.getDomicilios()) {
			d.setPersona(dto);
		}
		//dto.setNacionalidad(paisMapper.entityToDto(entity.getNacionalidad()));
		dto.setNombre(entity.getNombre());		
		return dto;
	}
	
	public List<PersonaDTO> lstEntityToLstDto(List<Persona> entity) {
		List<PersonaDTO> dtos = new ArrayList<PersonaDTO>();
		for(Persona enti :entity) {
			PersonaDTO dto = new PersonaDTO();
			dto.setId(enti.getId());
			dto.setNombre(enti.getNombre());
			dto.setApellido(enti.getApellido());		
			dto.setDni(enti.getDni());
			dto.setDomicilios(domicilioMapper.lstEntityToLstDto(enti.getDomicilios()));
			for(DomicilioDTO d : dto.getDomicilios()) {
				d.setPersona(dto);
			}
			//dto.setNacionalidad(paisMapper.entityToDto(entity.getNacionalidad()));
			dto.setNombre(enti.getNombre());	
			dtos.add(dto);
		}
		return dtos;
	}
}
