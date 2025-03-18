package examen.ejemplo.examen.services;

import java.util.List;

import examen.ejemplo.examen.domain.Equipo;

public interface EquipoService {
    Equipo añadir(Equipo equipo);
    Equipo obtenerPorId(Long id);
    Equipo obtenerPorNombre(String nombre);
    List<Equipo> obtenerTodos();
    void borrar(Long id);
    
}
