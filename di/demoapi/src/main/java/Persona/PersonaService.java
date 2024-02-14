package Persona;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {

  private PersonaRepository personaRepository;

  public void crearPersona(Persona persona) {
    personaRepository.save(persona);
  }
}
