package gestionresiduos_despacho.demo.dto;

import java.util.List;

public record GenerarOsRequest(Long hojaRutaId, List<Long> puntoIds) {
}
