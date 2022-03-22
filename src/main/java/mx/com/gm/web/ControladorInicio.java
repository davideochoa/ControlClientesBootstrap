package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/* @author David Ochoa <davideochoa@gmail.com> */

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var listaPersonas = personaService.listarPErsonas();
        log.info("Usuario que hizo login:"+user);
        model.addAttribute("listaPersonas",listaPersonas);
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        System.out.println("errores.hasErrors():"+errores.hasErrors());
        if(errores.hasErrors()){
            return "modificar";
        }else{
            personaService.guardar(persona);
            return "redirect:/";
        }
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }
    
    //@GetMapping("/eliminar/{idPersona}")
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        
        return "redirect:/";
    }
    
}
