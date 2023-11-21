package com.example.demo.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Domicilio;
import com.example.demo.model.Pais;

@Component
public class PaisMapper {
	@Autowired
	MonedaMapper monedaMapper;
	
	public Pais dtoToEntity(PaisDTO dto) {
		Pais p = new Pais();
		p.setGentilicio(dto.getGentilicio());
		p.setId(dto.getId());
		p.setMoneda(monedaMapper.dtoToEntity(dto.getMoneda()));
		p.getMoneda().getPaises().add(p);
		p.setNombre(dto.getNombre());
		p.setDomicilios(new ArrayList<Domicilio>());
		return p;
	}
	
	public PaisDTO entityToDto(Pais pais) {
		PaisDTO dto = new PaisDTO();
		dto.setGentilicio(pais.getGentilicio());
		dto.setId(pais.getId());
		dto.setMoneda(monedaMapper.entityToDto(pais.getMoneda()));
		dto.getMoneda().getPaises().add(dto);
		dto.setNombre(pais.getNombre());
		dto.setDomicilios(new ArrayList<DomicilioDTO>());
		return dto;
	}
	
}
