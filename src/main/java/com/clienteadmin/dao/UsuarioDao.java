package com.clienteadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clienteadmin.domain.Usuario;



public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre o apellido
    // List<Usuario> findByNombre(String nombre);
    // List<Usuario> findByApellido(String apellido);
    Usuario findByUsername(String username);
    // Puedes agregar otros métodos según tus necesidades
  

}
