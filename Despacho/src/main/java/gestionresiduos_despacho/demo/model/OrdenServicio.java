package gestionresiduos_despacho.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "ordenes_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hojaRutaId;
    private Long puntoRecoleccionId;
    private Long materialId;

    @Enumerated(EnumType.STRING)
    private EstadoOS estado = EstadoOS.PENDIENTE;
    private LocalDateTime horaLlegada;
    private LocalDateTime horaSalida;
    private String fotosPath;
    private String observaciones;
    private BigDecimal pesoKg;

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
