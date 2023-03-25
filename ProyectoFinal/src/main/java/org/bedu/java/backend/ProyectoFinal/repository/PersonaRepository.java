package org.bedu.java.backend.ProyectoFinal.repository;

import org.bedu.java.backend.ProyectoFinal.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
