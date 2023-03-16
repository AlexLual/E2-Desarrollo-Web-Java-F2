package org.bedu.bacend.java.PostWork6.service;

import org.bedu.bacend.java.PostWork6.model.Persona;
import org.bedu.bacend.java.PostWork6.persistence.AgendaMemoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final AgendaMemoryDao agendaDao;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaMemoryDao agendaDao) {
        this.validadorTelefono = validadorTelefono;
        this.agendaDao = agendaDao;
    }

    public Persona guardaPersona(Persona persona) {

        if (!validadorTelefono.isValido(persona.getTelefono())) {
            return null;
        }
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }

    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }
}


//La clase tiene dos variables privadas, validadorTelefono y agendaDao. validadorTelefono
// es una instancia de la clase ValidadorTelefono y agendaDao es una instancia de la clase
// AgendaMemoryDao. Estas dos instancias se inicializan en el constructor de la clase utilizando
// la anotación @Autowired de Spring, lo que sugiere que estas instancias son gestionadas por el
// contenedor de Spring y se les asigna automáticamente.
//La clase tiene dos métodos públicos llamados guardaPersona y getPersonas.
// El método guardaPersona acepta una instancia de Persona como entrada y devuelve
// una instancia de Persona como salida. Este método valida el número de teléfono de la persona utilizando
// la instancia validadorTelefono y si el número de teléfono no es válido, devuelve null. Si el número de
// teléfono es válido, se utiliza el método limpiaNumero de validadorTelefono para eliminar cualquier caracter
// no numérico del número de teléfono. Luego, se llama al método guardaPersona de agendaDao para guardar la
// persona en la memoria y devuelve la instancia de Persona guardada.
//El método getPersonas devuelve un conjunto de instancias de Persona. Este método llama al método getPersonas
// de agendaDao para obtener todas las instancias de Persona almacenadas en memoria y las devuelve en un conjunto.
//En resumen, esta clase es un servicio de gestión de contactos que valida y almacena instancias de Persona en memoria.
// Utiliza una instancia de ValidadorTelefono para validar y dar formato al número de teléfono de la persona, y utiliza
// una instancia de AgendaMemoryDao para almacenar y recuperar instancias de Persona en memoria.