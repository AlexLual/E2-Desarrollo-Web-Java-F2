package org.bedu.java.backend.ProyectoFinal.service;

import org.bedu.java.backend.ProyectoFinal.model.Persona;
import org.bedu.java.backend.ProyectoFinal.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    private PersonaRepository repository;

    @Override
    public List<Persona> ListarPersonas() {
        return repository.findAll();
    }

    public Persona guardarPersona(Persona persona){
        return repository.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Persona actualizaPersona(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
repository.deleteById(id);
    }

}
