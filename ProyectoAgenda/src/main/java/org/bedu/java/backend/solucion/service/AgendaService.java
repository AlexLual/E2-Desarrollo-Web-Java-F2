package org.bedu.java.backend.solucion.service;

import org.bedu.java.backend.solucion.model.Persona;
import org.bedu.java.backend.solucion.persistence.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AgendaService {
    private final ValidadorTelefono validadorTelefono;
    @Autowired
    private final PersonaRepository personaRepository;
    private static final String FORMATO_INICIAL_TELEFONO = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FORMATO_FINAL_TELEFONO = "($1)-$2-$3";
    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, PersonaRepository personaRepository) {
        this.validadorTelefono = validadorTelefono;
        this.personaRepository = personaRepository;
    }

    public Persona guardaPersona(Persona persona) {
        String nombre = persona.getNombre();
        List<Persona> personass = getPersonas();
        for (Persona persona1:personass) {
            if(persona1.getNombre().equals(nombre)){
                return persona;
            }
        }
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());
        String telefonoFinal = String.valueOf(telefono).replaceFirst(FORMATO_INICIAL_TELEFONO, FORMATO_FINAL_TELEFONO);
        persona.setTelefono(telefonoFinal);
        return personaRepository.save(persona);
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll(Sort.by("nombre"));
    }
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
