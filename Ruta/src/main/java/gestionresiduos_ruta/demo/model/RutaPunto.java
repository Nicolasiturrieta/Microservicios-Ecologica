package gestionresiduos_ruta.demo.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ruta_puntos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutaPunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rutaId;
    private Long puntoRecoleccionId;
    private Integer orden;
    private LocalTime ventanaInicio;
    private LocalTime ventanaFin;
}
