package examen.ejemplo.examen.services;

import java.util.List;

import examen.ejemplo.examen.domain.Jugador;

public interface JugadorService {
    
    Jugador añadir(Jugador jugador);
    
    List<Jugador> obtenerEquipo();
    
    Jugador obtenerPorId(String nombre);

    void borrarJugador(String nombre);

    List<Jugador> jugadoresPorEquipo (Long idEquipo); //Mirar esto

    List<Jugador> jugadoresMenores();

}
