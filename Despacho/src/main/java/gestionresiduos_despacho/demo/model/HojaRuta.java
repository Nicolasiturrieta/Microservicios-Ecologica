package gestionresiduos_despacho.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hojas_ruta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HojaRuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rutaId;
    private LocalDate fecha;
    
    @Enumerated(EnumType.STRING)
    private EstadoHoja estado = EstadoHoja.BORRADOR;
}
