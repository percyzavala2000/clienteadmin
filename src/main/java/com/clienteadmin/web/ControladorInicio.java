package com.clienteadmin.web;

import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clienteadmin.domain.Persona;
import com.clienteadmin.servicio.PersonaService;

import jakarta.validation.Valid;

@Controller
@Slf4j

public class ControladorInicio {
  @Autowired
  private PersonaService personaService;

  @GetMapping("/")
  public String inicio(Model model, @AuthenticationPrincipal User user) {
    var personas = personaService.listarPersonas();
    log.info("Ejecutando el controlador Spring MVC");
    log.info("Personas encontradas: {}", personas.iterator().hasNext() ? personas.iterator().next() : "Ninguna");

    model.addAttribute("personas", personas);
    model.addAttribute("usuario", user.getUsername());
    log.info("Usuario autenticado: {}", user.getUsername());
    log.info("Roles del usuario: {}", user.getAuthorities());
    return "index";
  }

  @GetMapping("/agregar")
  public String agregar(Persona persona) {
    return "modificar";
  }

  @GetMapping("/editar/{id}")
  public String editar(Persona persona, Model model) {
    persona = personaService.encontrarPersona(persona);
    model.addAttribute("persona", persona);
    log.info("Persona para editar:", persona);
    return "modificar";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminar(Persona persona) {
    personaService.eliminar(persona);
    return "redirect:/";
  }

  @PostMapping("/guardar")
  public String guardar(@Valid Persona persona, Errors errors) {
    if (errors.hasErrors()) {
      return "modificar";
    }
    personaService.guardar(persona);
    return "redirect:/";
  }

}