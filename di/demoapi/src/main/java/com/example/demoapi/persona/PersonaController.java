<<<<<<< HEAD:di/demoapi/src/main/java/com/example/demoapi/persona/PersonaController.java
package com.example.demoapi.persona;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController // publica los endpoints (urls con peticiones)
@RequestMapping("/persona")

@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping("/crear") // http://localhost:8080/persona/crear
    public void insertarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

}
=======
package Persona;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //publica los endpoints
@RequestMapping("/persona")
@RequiredArgsConstructor

public class PersonaController {

  private final PersonaService personaService;
  @PostMapping("/crear") //http://localhost:8080/persona/body
  
  public void insertarPersona(@RequestBody Persona persona) {
    personaService.crearPersona(persona);
  }
}
>>>>>>> c7f339dc3cc938da164715993a817d0531eee417:di/demoapi/src/main/java/Persona/PersonaController.java
