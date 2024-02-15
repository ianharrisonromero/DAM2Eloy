<<<<<<< HEAD:di/demoapi/src/main/java/com/example/demoapi/persona/PersonaService.java
package com.example.demoapi.persona;

import org.springframework.beans.factory.annotation.Autowired;
=======
package Persona;

>>>>>>> c7f339dc3cc938da164715993a817d0531eee417:di/demoapi/src/main/java/Persona/PersonaService.java
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {
<<<<<<< HEAD:di/demoapi/src/main/java/com/example/demoapi/persona/PersonaService.java
    @Autowired
    private PersonaRepository personaRepository;

    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }
=======

  private PersonaRepository personaRepository;

  public void crearPersona(Persona persona) {
    personaRepository.save(persona);
  }
>>>>>>> c7f339dc3cc938da164715993a817d0531eee417:di/demoapi/src/main/java/Persona/PersonaService.java
}
