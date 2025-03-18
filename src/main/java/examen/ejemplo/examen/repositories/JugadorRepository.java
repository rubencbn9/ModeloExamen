package examen.ejemplo.examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import examen.ejemplo.examen.domain.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, String> {
    
    List<Jugador> findByEquipoId(Long idEquipo);
    List<Jugador> findByEdadLessThan(Integer edad);
}
 