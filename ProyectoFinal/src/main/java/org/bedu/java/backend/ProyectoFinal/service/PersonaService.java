package org.bedu.java.backend.ProyectoFinal.service;

import org.bedu.java.backend.ProyectoFinal.model.Persona;

import java.util.List;

public interface PersonaService {


    public List<Persona> ListarPersonas();

    public Persona guardarPersona(Persona persona);

    public Persona obtenerPersonaPorId(Long id);
    public Persona actualizaPersona(Persona persona);
    public void eliminarPersona(Long id);

}
