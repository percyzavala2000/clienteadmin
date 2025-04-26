package com.clienteadmin.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
   private UserDetailsService userDetailsService;
    // Configuración de autenticación en memoria
  /*   @Bean
    public UserDetailsService userDetailsService() {
        var admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        var user = User.withUsername("user")
                .password("{noop}user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    } */
   @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    // Configuración de seguridad
    @Bean
   
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return  http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers( "/agregar", "/guardar", "/editar/**", "/eliminar/**").hasRole("ADMIN")
                .requestMatchers("/").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // Asegúrate de tener esta página
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .exceptionHandling(exception -> exception.accessDeniedPage("/errores/403")).build();

       
    }
}