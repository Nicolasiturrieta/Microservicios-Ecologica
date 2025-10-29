package gestionresiduos_gateway.demo.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "gateway");
        status.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return status;
    }
    
    @GetMapping("/")
    public String home() {
        return "Gateway Microservicios Ecológicos - Funcionando correctamente";
    }
}