package com.contreraspatricio.personas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contreraspatricio.personas.exception.ResourceNotFoundException;
import com.contreraspatricio.personas.model.Persona;
import com.contreraspatricio.personas.repository.PersonaRepository;

@RestController
@RequestMapping("/v1")
public class PersonaController  {
	
	//inyeccion de dependencias
	@Autowired
	PersonaRepository personaRepository;
	
	//Get all personas
	@GetMapping("/personas")
	public List<Persona> getAllPersonas(){
		return personaRepository.findAll();
	}
	
	//Create a new Persona
	@PostMapping("/personas")
	public Persona createPersona(@Valid @RequestBody Persona persona) {
		return personaRepository.save(persona);
	}
	
	//Get obtener por id una persona
	@GetMapping("/personas/{id}")
	public Persona getPersonaById(@PathVariable(value = "id") Long personaId) {
		
		return personaRepository.findById(personaId)
				.orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
	}
	
	//Update a Persona
	@PutMapping("personas/{id}")
	public Persona updatePersona(@PathVariable(value = "id") Long personaId, @Valid @RequestBody Persona personaInfo) {
		
		Persona persona = personaRepository.findById(personaId)
				.orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
		
		persona.setNombre(personaInfo.getNombre());
		persona.setApellido(personaInfo.getApellido());
		
		Persona updatedPersona = personaRepository.save(persona);
		
		return updatedPersona;
	}
		//metodo delete
		@DeleteMapping("/personas/{id}")
		public ResponseEntity<?> deletePersona(@PathVariable(value = "id") Long personaId){
			
			Persona persona = personaRepository.findById(personaId)
					.orElseThrow(()-> new ResourceNotFoundException("Persona", "id", personaId));
			
			personaRepository.delete(persona);
			
			return ResponseEntity.ok().build();
		}
		
	
	
}
