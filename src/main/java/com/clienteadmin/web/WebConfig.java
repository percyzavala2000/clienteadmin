package com.clienteadmin.web;


import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
public class WebConfig implements WebMvcConfigurer {
  
  
    // Aquí puedes agregar configuraciones adicionales de Spring MVC si es necesario
    // Por ejemplo, puedes agregar interceptores, convertidores, etc.

    // Ejemplo de un interceptor (descomentarlo si es necesario)
    /*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MiInterceptor());
    }
    */
    // Ejemplo de un convertidor (descomentarlo si es necesario)
    @Bean
    public LocaleResolver localeResolver() {
      var slr=new SessionLocaleResolver();
      slr.setDefaultLocale(new Locale("es", "PE"));
      return slr;
      
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
      var lci=new LocaleChangeInterceptor();
      lci.setParamName("lang");
      return lci;
    }
     @SuppressWarnings("null")
    @Override
    public void addInterceptors( InterceptorRegistry registry) {
      registry.addInterceptor(localeChangeInterceptor());
    }
    @SuppressWarnings("null")
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("index");
      registry.addViewController("/login").setViewName("login");
      registry.addViewController("/agregar").setViewName("agregar");
      registry.addViewController("/guardar").setViewName("guardar");
      registry.addViewController("/editar").setViewName("editar");
      registry.addViewController("/eliminar").setViewName("eliminar");
      registry.addViewController("/errores/403").setViewName("errores/403");
   
    } 

}