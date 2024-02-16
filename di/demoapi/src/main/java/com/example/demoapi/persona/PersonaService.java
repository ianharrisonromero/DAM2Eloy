package com.example.demoapi.persona;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaService {

  @Autowired
  private PersonaRepository personaRepository;

  public void crearPersona(Persona persona) {
    personaRepository.save(persona);
  }

  public boolean borrarPersona(Integer id) {
    if (personaRepository.findById(id).isPresent()) {
      personaRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public Optional<Persona> obtenerPersona(Integer id) {
    return personaRepository.findById(id);
  }

  public List<Persona> obtenerTodas() {
    return personaRepository.findAll();
  }

  public Optional<Persona> actualizarPersona(Integer id, Persona persona) {
    Optional<Persona> p = personaRepository.findById(id);
    if (p.isPresent()) {
      p.get().setNombre(persona.getNombre());
      p.get().setApellidos(persona.getApellidos());
      p.get().setEmail(persona.getEmail());
      personaRepository.saveAndFlush(p.get());
    }
    return p;
  }
}
