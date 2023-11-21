package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.demo.model.Domicilio;



@Component
public class DomicilioMapper {
	@Autowired
	PaisMapper paisMapper;

//	@Autowired
//	PersonaMapper personaMapper;
	
	
	public Domicilio dtoToEntity(DomicilioDTO dto) {
		Domicilio d = new Domicilio();
		d.setId(dto.getId());
		d.setAltura(dto.getAltura());
		d.setCalle(dto.getCalle());	
		d.setPais(paisMapper.dtoToEntity(dto.getPais()));
		d.getPais().getDomicilios().add(d);
		//d.setPersona(personaMapper.dtoToEntity(dto.getPersona()));
		return d;
	}
	
	public DomicilioDTO entityToDto(Domicilio dom) {
		DomicilioDTO dto = new DomicilioDTO();
		dto.setAltura(dom.getAltura());
		dto.setCalle(dom.getCalle());
		dto.setId(dom.getId());
		dto.setPais(paisMapper.entityToDto(dom.getPais()));
		dto.getPais().getDomicilios().add(dto);
		//dto.setPersona(personaMapper.entityToDto(dom.getPersona()));		
		return dto;
	}
	
	public List<DomicilioDTO> lstEntityToLstDto(List<Domicilio> entity) {
		List<DomicilioDTO> dtos = new ArrayList<DomicilioDTO>();
		for(Domicilio enti :entity) {
			DomicilioDTO dto = new DomicilioDTO();
			dto.setAltura(enti.getAltura());
			dto.setCalle(enti.getCalle());
			dto.setId(enti.getId());
			dto.setPais(paisMapper.entityToDto(enti.getPais()));
			dto.getPais().getDomicilios().add(dto);
			//dto.setPersona(personaMapper.entityToDto(enti.getPersona()));	
			dtos.add(dto);
		}
		return dtos;
	}
	
	public List<Domicilio> lstDtoToEntity(List<DomicilioDTO> dtos) {
		List<Domicilio> ent = new ArrayList<Domicilio>();
		for(DomicilioDTO dto :dtos) {
			Domicilio d = new Domicilio();
			d.setId(dto.getId());
			d.setAltura(dto.getAltura());
			d.setCalle(dto.getCalle());	
			d.setPais(paisMapper.dtoToEntity(dto.getPais()));
			d.getPais().getDomicilios().add(d);
			//d.setPersona(personaMapper.dtoToEntity(dto.getPersona()));
			ent.add(d);
		}
		return ent;
	}
	
}
