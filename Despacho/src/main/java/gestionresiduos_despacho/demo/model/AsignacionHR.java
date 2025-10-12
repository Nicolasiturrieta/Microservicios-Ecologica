package gestionresiduos_despacho.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignaciones_hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionHR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hojaRutaId;
    private Long choferId;
    private Long vehiculoId;
}
