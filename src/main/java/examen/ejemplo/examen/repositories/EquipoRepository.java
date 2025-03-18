package examen.ejemplo.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import examen.ejemplo.examen.domain.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    Equipo findByNombre(String nombre);
}
