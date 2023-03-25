package org.bedu.bacend.java.PostWork6.controller;



import jakarta.validation.Valid;
import org.bedu.bacend.java.PostWork6.model.Persona;
import org.bedu.bacend.java.PostWork6.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;




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
    public ModelAndView registra(@Valid Persona persona) {

        agendaService.guardaPersona(persona);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }

}

//Este código define un controlador REST para la agenda de contactos.
// La anotación @RestController indica que la clase define un controlador REST y
// @RequestMapping indica que la ruta de acceso a este controlador comienza con "/api/v1/agenda".
//La clase tiene dos métodos de controlador: guardaPersona() y getPersonas().
//El método guardaPersona() se encarga de agregar una nueva persona a la agenda.
// Se utiliza la anotación @PostMapping para indicar que este método debe responder a
// las solicitudes HTTP POST. La persona a agregar se recibe como parámetro en la solicitud HTTP
// en formato JSON y se deserializa automáticamente en un objeto Persona gracias a la anotación @RequestBody.
// Luego, se llama al método guardaPersona() del servicio de la agenda para agregar la persona y se devuelve
// una respuesta HTTP que indica si la operación fue exitosa o no.
//El método getPersonas() se encarga de devolver una lista de todas las personas en la agenda.
// Se utiliza la anotación @GetMapping para indicar que este método debe responder a las solicitudes HTTP GET.
// Se llama al método getPersonas() del servicio de la agenda para obtener la lista de personas y se devuelve
// una respuesta HTTP que contiene la lista en formato JSON.