package org.bedu.bacend.java.PostWork6.persistence;

import org.bedu.bacend.java.PostWork6.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
