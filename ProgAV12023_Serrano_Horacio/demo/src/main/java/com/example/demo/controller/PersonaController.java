package com.example.demo.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonaDTO;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;


@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	PersonaRepository perRepo;
	
	@Autowired
	PersonaService personaService;

	@GetMapping("/saludar")
	public String saludar() {
		return "Hola";
	}
	
	
	
	@GetMapping("/persona/{id}")
	public ResponseEntity<?> obtenerPersona(@PathVariable Long id) {
		try {
			if(id==null) {
				return new ResponseEntity<String>("Falta Id", HttpStatus.BAD_REQUEST);
			}
			else {
				Optional<Persona> opt = perRepo.findById(id);
				if (opt.isPresent()) {
					return new ResponseEntity<PersonaDTO>(personaService.buscarPorId(id), HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("No Encontrado", HttpStatus.CONFLICT);
				}
			}
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
	}
	
	
	@GetMapping("/personas")
	public ResponseEntity<?> obtenerPersonas(){
		List<PersonaDTO> lista = personaService.buscarTodas();
		return new ResponseEntity<List<PersonaDTO>>(lista, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/personas")
	public ResponseEntity<?> crearPersona(@RequestBody @Validated List<PersonaDTO> dtos){
		for(PersonaDTO dto : dtos) {
			if(dto.getId()==null) {
				personaService.insertarPesona(dto);
			}
		}
		return new ResponseEntity<String>("Personas Creadas", HttpStatus.OK);	
	}
	
	

	
	@PostMapping("/persona")
	public ResponseEntity<?> crearPersona(@RequestBody @Validated PersonaDTO dto){
		System.out.print(dto.toString());
		if(personaService.insertarPesona(dto) && dto.getId()==null) {
			return new ResponseEntity<String>("Persona Creada", HttpStatus.OK);	
		}else {
			return new ResponseEntity<String>("No se permite Insertar Con Identidad", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/persona")
	public ResponseEntity<?> modificarPersona(@RequestBody @Validated PersonaDTO dto){
		if(personaService.modificarPesona(dto) && dto.getId()!=null) {
			return new ResponseEntity<String>("Persona Modificada", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No se permite Insertar Con Identidad", HttpStatus.BAD_REQUEST);
		}		
	}
	
	
	
	
	
	
	
	
	@DeleteMapping("/persona")
	public ResponseEntity<?> eliminarPersona(@RequestBody PersonaDTO dto){
		System.out.print(dto.toString());
		if (dto.getId()==null) {
			return new ResponseEntity<String>("Falta Id", HttpStatus.BAD_REQUEST);
		}else {
			perRepo.deleteById(dto.getId());
			return new ResponseEntity<String>("Persona Eliminada", HttpStatus.OK);
		}
	}
	
}
