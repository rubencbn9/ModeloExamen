package examen.ejemplo.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examen.ejemplo.examen.domain.Jugador;
import examen.ejemplo.examen.repositories.EquipoRepository;
import examen.ejemplo.examen.repositories.JugadorRepository;


@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    EquipoRepository equipoRepository;

    public Jugador añadir(Jugador jugador) {
      return jugadorRepository.save(jugador);
    }

    public List<Jugador> obtenerEquipo() {
      return jugadorRepository.findAll();
    }

    public Jugador obtenerPorId(String nombre) {
       return jugadorRepository.findById(nombre).orElse(null);
    }

    public void borrarJugador(String nombre) {
        jugadorRepository.deleteById(nombre);
    }

    public List<Jugador> jugadoresPorEquipo(Long idEquipo) {
      return jugadorRepository.findByEquipoId(idEquipo);
    }

    public List<Jugador> jugadoresMenores() {
        return jugadorRepository.findByEdadLessThan(18);
    }
    
}
