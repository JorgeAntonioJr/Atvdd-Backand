import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacoesService transacoesService;
    private final ContaMapper contaMapper;

    @Autowired
    public TransacaoController(TransacoesService transacoesService, ContaMapper contaMapper) {
        this.transacoesService = transacoesService;
        this.contaMapper = contaMapper;
    }

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO requestDTO) {
        Transacao transacao = transacoesService.gerarTransacao(requestDTO);

        // Mapeando os dados da resposta
        ContaDTO origemDTO = contaMapper.toContaDTO(transacao.getOrigem());
        ContaDTO destinoDTO = contaMapper.toContaDTO(transacao.getDestino());

        return new TransacaoResponseDTO(origemDTO, destinoDTO, transacao.getValor());
    }
}
