package examen.ejemplo.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import examen.ejemplo.examen.domain.Jugador;
import examen.ejemplo.examen.services.EquipoService;
import examen.ejemplo.examen.services.JugadorService;
import jakarta.validation.Valid;




@Controller
public class JugadorController {

  
    
    @Autowired
    JugadorService jugadorService;
    
    @Autowired
    EquipoService equipoService;


    @GetMapping("/")
    public String Index(Model model) {
        model.addAttribute("listaJugadores", jugadorService.obtenerEquipo());
        model.addAttribute("listaEquipos", equipoService.obtenerTodos());
        model.addAttribute("equipoSeleccionado", "Todos");
        return "playerListView";
    }

    @GetMapping("/porEquipos/{idEquipo}")
    public String getPorEquipos(@PathVariable Long idEquipo , Model model) {
        if(idEquipo == 0){
            return "redirect:/";
        }else{
            model.addAttribute("listaJugadores", jugadorService.jugadoresPorEquipo(idEquipo));
            model.addAttribute("listaEquipos", equipoService.obtenerTodos());
            model.addAttribute("equipoSeleccionado", equipoService.obtenerPorId(idEquipo).getNombre());
            return "playerListView";
        }
        
    }

    @GetMapping("/jugadoresMenores")
    public String getMenores(Model model) {
        model.addAttribute("listaJugadores", jugadorService.jugadoresMenores());
        return "menoresListView";
    }
    

    @GetMapping("/nuevo")
    public String añadirJugador( Model model) {
        model.addAttribute("jugadorForm", new Jugador());
        model.addAttribute("listaEquipos", equipoService.obtenerTodos());
        return "newPlayerView";
    }

    @PostMapping("/nuevo/submit")
    public String EnvioForm(@Valid Jugador jugadorForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/nuevo";
        }else{
            jugadorService.añadir(jugadorForm);
        }
        
        return "redirect:/";
    }

    @GetMapping("/borrar/{nombre}")
    public String ShowDelete(@PathVariable String nombre) {
        jugadorService.borrarJugador(nombre);
        return "redirect/";
    }
    
    
    

    
    
}
