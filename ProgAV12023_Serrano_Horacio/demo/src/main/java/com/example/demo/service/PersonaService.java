package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaMapper;
import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.model.Domicilio;


@Service
public class PersonaService {
	@Autowired
	PersonaMapper personaMapper;
	@Autowired
	PersonaRepository perRepo;
	
	
	public PersonaDTO buscarPorId(Long Id){
		Optional<Persona>  o = perRepo.findById(Id);
		if (o.isPresent()) {
			Persona p = o.get();
			PersonaDTO dto = personaMapper.entityToDto(p);
			return dto;
		}else {
			return null;
		}
	}
	
	public List<PersonaDTO> buscarTodas(){
		List<Persona> lista = (List<Persona>) perRepo.findAll();
		List<PersonaDTO> l = personaMapper.lstEntityToLstDto(lista);
		return l;
	}
	
	public boolean insertarPesona(PersonaDTO dto) {
		Persona ent = personaMapper.dtoToEntity(dto);
		for(Domicilio dom : ent.getDomicilios()){
			dom.setPersona(ent);
		}
		perRepo.save(ent);			
		return true;		
	}
	
	public boolean modificarPesona(PersonaDTO dto) {
		Persona ent = personaMapper.dtoToEntity(dto);
		for(Domicilio dom : ent.getDomicilios()){
			dom.setPersona(ent);
		}
		perRepo.save(ent);			
		return true;		
	}
}

