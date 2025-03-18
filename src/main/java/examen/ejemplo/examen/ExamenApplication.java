package examen.ejemplo.examen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import examen.ejemplo.examen.domain.Equipo;
import examen.ejemplo.examen.domain.Jugador;
import examen.ejemplo.examen.services.EquipoService;
import examen.ejemplo.examen.services.JugadorService;

@SpringBootApplication
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(EquipoService equipoService,
			JugadorService jugadorService) {
		return args -> {
			Equipo equipo1 = equipoService.añadir(new Equipo(0L, "Depor"));
			Equipo equipo2 = equipoService.añadir(new Equipo(0L, "Barça"));
			jugadorService.añadir(new Jugador("Jose", 15, equipo1));
			jugadorService.añadir(new Jugador("Eva", 25, equipo1));
			jugadorService.añadir(new Jugador("Ana", 23, equipo2));
			jugadorService.añadir(new Jugador("Juan", 17, equipo2));
		};
	}

}
