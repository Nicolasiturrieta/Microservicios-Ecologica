package gestionresiduos_gateway.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DemoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void healthEndpointRespondsOk() {
        webTestClient.get().uri("/health")
            .exchange()
            .expectStatus().isOk();
    }
}
