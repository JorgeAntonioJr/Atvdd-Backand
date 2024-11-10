package com.exemplo.servico.controller;

import com.exemplo.servico.dto.RequisicaoDTO;
import com.exemplo.servico.dto.RespostaDTO;
import com.exemplo.servico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("/consulta")
    public RespostaDTO consulta() {
        return servicoService.consultaDadosExternos();
    }

    @PostMapping("/processar")
    public RespostaDTO processarRequisicao(@RequestBody RequisicaoDTO requisicao) {
        return servicoService.processarDados(requisicao);
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "{\"estudante\": \"Seu Nome\", \"projeto\": \"Web Service Exemplo\"}";
    }
}
