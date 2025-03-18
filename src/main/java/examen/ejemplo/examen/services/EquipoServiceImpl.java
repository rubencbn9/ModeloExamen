package examen.ejemplo.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examen.ejemplo.examen.domain.Equipo;
import examen.ejemplo.examen.repositories.EquipoRepository;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    EquipoRepository equipoRepository;

    public Equipo añadir(Equipo equipo) {
      equipoRepository.save(equipo);
      return equipo;
    }

    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
         
    }

    public Equipo obtenerPorNombre(String nombre) {
        return equipoRepository.findByNombre(nombre);
    }

    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
         
    }

    public void borrar(Long id) {
        equipoRepository.deleteById(id);
        
    }

    
}
