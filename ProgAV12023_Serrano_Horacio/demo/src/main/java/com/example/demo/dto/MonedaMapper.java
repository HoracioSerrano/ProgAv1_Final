package com.example.demo.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.model.Moneda;

@Component
public class MonedaMapper {
	public Moneda dtoToEntity(MonedaDTO dto) {
		Moneda m = new Moneda();
		m.setId(dto.getId());
		m.setNombre(dto.getNombre());
		return m;
	}
	
	public MonedaDTO entityToDto(Moneda ent) {
		MonedaDTO dto = new MonedaDTO();
		dto.setId(ent.getId());
		dto.setNombre(ent.getNombre());
		dto.setPaises(new ArrayList<PaisDTO>());
		return dto;
	}
}
