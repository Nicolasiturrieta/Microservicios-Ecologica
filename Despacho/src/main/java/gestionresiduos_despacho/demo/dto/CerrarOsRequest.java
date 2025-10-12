package gestionresiduos_despacho.demo.dto;

import java.math.BigDecimal;

public record CerrarOsRequest(BigDecimal pesoKg, String observaciones) {
}
