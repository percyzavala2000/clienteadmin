package com.clienteadmin.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clienteadmin.dao.PersonaDao;
import com.clienteadmin.domain.Persona;



@Service
public class PersonaServiceImple implements PersonaService {
  @Autowired  
  private  PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {

        // Implementación del método para listar personas
        // Aquí puedes usar personaDao para acceder a la base de datos
        // y devolver una lista de personas.
        List<Persona> personas = (List<Persona>) personaDao.findAll();
        return personas;
      
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        // Implementación del método para guardar una persona
        // Aquí puedes usar personaDao para guardar la persona en la base de datos.
        personaDao.save(persona);
        // Puedes agregar lógica adicional si es necesario
        // por ejemplo, manejar excepciones o validar datos.
        // personaDao.save(persona);
        try {
       //si existe una persona con el mismo id
            if (personaDao.existsById(persona.getId())) {
                // Lógica para actualizar la persona existente
                personaDao.save(persona);
            } else {
                // Lógica para guardar la nueva persona
                personaDao.save(persona);
            }
        } catch (Exception e ) {
            // Manejo de excepciones
            // Aquí podrías registrar el error o lanzar una excepción personalizada.
        }
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        // Implementación del método para eliminar una persona
        // Aquí puedes usar personaDao para eliminar la persona de la base de datos.
        personaDao.delete(persona);
        // Puedes agregar lógica adicional si es necesario
        // por ejemplo, manejar excepciones o validar datos.
        // personaDao.delete(persona);
     
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        // Implementación del método para encontrar una persona
       return  personaDao.findById(persona.getId()).orElse(null);

    }

   
}
