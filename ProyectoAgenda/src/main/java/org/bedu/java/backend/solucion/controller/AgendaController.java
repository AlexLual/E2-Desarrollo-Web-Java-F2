package org.bedu.java.backend.solucion.controller;

import org.bedu.java.backend.solucion.model.Persona;
import org.bedu.java.backend.solucion.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {

    private final AgendaService agendaService;


    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, Errors errors) {
        String vistaResultado = "index";
        if(errors.hasErrors()){
            vistaResultado = "index";
            ModelAndView mav = new ModelAndView(vistaResultado);
            mav.addObject("listaPersonas", agendaService.getPersonas());
            return mav;
        }

        agendaService.guardaPersona(persona);
        ModelAndView mav = new ModelAndView(vistaResultado);
        mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }

    @GetMapping("/personas/{id}")
    public  String eliminarPersona(@PathVariable Long id){
        agendaService.eliminarPersona(id);
        return "redirect:/index";
    }
}
