package com.contreraspatricio.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contreraspatricio.personas.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>  {

}
