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
