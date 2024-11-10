package com.exemplo.servico.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClient {

    private final RestTemplate restTemplate;

    public APIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String consultarAPIExterna() {
        // Realiza uma requisição GET para uma API externa (ex: serviço de previsão do tempo)
        String apiUrl = "https://api.exemplo.com/consulta";
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
