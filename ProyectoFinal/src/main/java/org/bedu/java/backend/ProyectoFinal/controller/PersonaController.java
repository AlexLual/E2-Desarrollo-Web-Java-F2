package org.bedu.java.backend.ProyectoFinal.controller;

import org.bedu.java.backend.ProyectoFinal.model.Persona;
import org.bedu.java.backend.ProyectoFinal.repository.PersonaRepository;
import org.bedu.java.backend.ProyectoFinal.service.PersonaService;
import org.bedu.java.backend.ProyectoFinal.service.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PersonaController {
    @Autowired
    private PersonaService service;

    @GetMapping({"/personas","/"})
    public String ListarPersonas(Model modelo){
        modelo.addAttribute("personas",service.ListarPersonas());
        return "personas";
    }

    @GetMapping("/personas/nuevo")
    public String crearPersonaFormulario(Model modelo){
        Persona persona = new Persona();
        modelo.addAttribute("persona", persona);
        return "crear_persona";
    }
    @PostMapping("/personas")
    public String guardarPersona(@Valid Persona persona, Errors errors){
    String vistaResultado = "redirect:/personas";
    if(errors.hasErrors()){
        System.out.println("error!!");
        vistaResultado = "redirect:/personas/nuevo";
        return vistaResultado;
    }
        System.out.println("Sin error!!");
    service.guardarPersona(persona);
    return vistaResultado;
    }

@GetMapping("/personas/editar/{id}")
public String formularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("persona",service.obtenerPersonaPorId(id));
        return "editar_persona";
}

@PostMapping("/personas/{id}")
    public String actualizarPersona(@PathVariable Long id,@ModelAttribute("persona") Persona persona, Model modelo){
        Persona personaExistente =service.obtenerPersonaPorId(id);
        personaExistente.setId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellido(persona.getApellido());
        personaExistente.setTelefono(persona.getTelefono());
        service.actualizaPersona(personaExistente);
        return "redirect:/personas";
}
@GetMapping("/personas/{id}")
    public  String eliminarPersona(@PathVariable Long id){
        service.eliminarPersona(id);
        return "redirect:/personas";
}
}
