package com.exemplo.servico.service;

import com.exemplo.servico.dto.RequisicaoDTO;
import com.exemplo.servico.dto.RespostaDTO;
import com.exemplo.servico.util.APIClient;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    private final APIClient apiClient;

    public ServicoService(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public RespostaDTO consultaDadosExternos() {
        // Lógica para consultar dados externos, exemplo: dados meteorológicos
        String dados = apiClient.consultarAPIExterna();
        return new RespostaDTO("origem", "destino", dados);
    }

    public RespostaDTO processarDados(RequisicaoDTO requisicao) {
        // Lógica para processar dados, como consultar e manipular a requisição
        return new RespostaDTO(requisicao.getOrigem(), requisicao.getDestino(), "Resultado do processamento");
    }
}
