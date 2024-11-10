package com.exemplo.fipeconsult;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    private final String URL_FIPE = "https://parallelum.com.br/fipe/api/v1/carros/valor";

    // Método que recebe os dados do carro e consulta a Tabela FIPE
    @PostMapping("/consultar")
    public ResponseEntity<ValorFipeResponse> consultarFipe(@RequestBody Carro carro) {
        // Instanciando o RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Criando a URL de requisição com os parâmetros
        String url = URL_FIPE + "/" + carro.getMarca().toLowerCase() + "/" +
                     carro.getModelo().toLowerCase() + "/" + carro.getAno();

        try {
            // Fazendo a requisição GET à API FIPE
            ResponseEntity<ValorFipeResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    ValorFipeResponse.class
            );

            // Retornando a resposta da API
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

        } catch (Exception e) {
            // Se ocorrer algum erro ao consultar, retornamos um erro customizado
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
