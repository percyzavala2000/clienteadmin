package com.clienteadmin.dao;

import org.springframework.data.repository.CrudRepository;

import com.clienteadmin.domain.Persona;


public interface PersonaDao extends CrudRepository<Persona , Long> {
  
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre o apellido
    // List<Persona> findByNombre(String nombre);
    // List<Persona> findByApellido(String apellido);

}