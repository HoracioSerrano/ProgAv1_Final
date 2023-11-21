package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaMapper;
import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/listados")
public class ListadosController {
	@Autowired
	PersonaRepository perRepo;
	
	@Autowired
	PersonaMapper personaMapper;
	
	@GetMapping({"/porapellido/{apellido}"})
	public ResponseEntity<?> porApellido (@PathVariable String apellido){
		List<Persona> lista = perRepo.findAllByApellidoOrderById(apellido);
		List<PersonaDTO> l = personaMapper.lstEntityToLstDto(lista);
		return new ResponseEntity<List<PersonaDTO>>(l, HttpStatus.OK);
	}
	@GetMapping({"/porPaisDomicilio/{pais}"})
	public ResponseEntity<?> porPaisDomicilio (@PathVariable String pais){
		List<Persona> lista = perRepo.buscarPorPaisDomicilio(pais);
		List<PersonaDTO> l = personaMapper.lstEntityToLstDto(lista);
		return new ResponseEntity<List<PersonaDTO>>(l, HttpStatus.OK);
	}
	
	@GetMapping({"/buscarPorApellidoYPais/{apellido}/{pais}"})
	public ResponseEntity<?> buscarPorApellidoYPais (@PathVariable String apellido, @PathVariable String pais){
		List<Object> lista = perRepo.buscarPorApellidoYPais(apellido, pais);

		return new ResponseEntity<List<Object>>(lista, HttpStatus.OK);
	}


}
