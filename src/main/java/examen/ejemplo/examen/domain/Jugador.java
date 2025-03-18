package examen.ejemplo.examen.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nombre")

public class Jugador {

    @Id
    private String nombre;

    @Min(16)@Max(40)
    private Integer edad;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE) 
    private Equipo equipo;
}