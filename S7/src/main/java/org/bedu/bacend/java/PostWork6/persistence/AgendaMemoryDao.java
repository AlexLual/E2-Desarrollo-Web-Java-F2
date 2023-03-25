package org.bedu.bacend.java.PostWork6.persistence;

import org.bedu.bacend.java.PostWork6.model.Persona;
import org.bedu.bacend.java.PostWork6.service.FormateadorTelefono;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();
    private final FormateadorTelefono formateadorTelefono;

    public AgendaMemoryDao(FormateadorTelefono formateadorTelefono) {
        this.formateadorTelefono = formateadorTelefono;
    }

    public Persona guardaPersona(Persona persona) {
        persona.setTelefono(formateadorTelefono.formatea(persona.getTelefono()));
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}

//La clase tiene una variable privada llamada personas, que es una instancia de la clase SortedSet<Persona>.
// Un SortedSet es un conjunto que mantiene los elementos ordenados en función de un comparador proporcionado.
// En este caso, la clase Persona debe implementar la interfaz Comparable<Persona> para definir un orden natural
// para las instancias de Persona.
//La clase tiene dos métodos públicos llamados guardaPersona y getPersonas. El método guardaPersona acepta
// una instancia de Persona como entrada y devuelve una instancia de Persona como salida. Este método agrega
// la instancia de Persona proporcionada al conjunto personas utilizando el método add y luego devuelve la misma
// instancia.
//El método getPersonas devuelve un conjunto de instancias de Persona. Este método devuelve el conjunto personas
// sin modificarlo.
//En resumen, esta clase es una implementación de un DAO (Data Access Object) que proporciona métodos
// para almacenar y recuperar instancias de Persona en memoria. Utiliza un SortedSet para mantener las
// instancias de Persona en un orden natural y proporciona métodos para agregar y recuperar instancias de Persona
// del conjunto.