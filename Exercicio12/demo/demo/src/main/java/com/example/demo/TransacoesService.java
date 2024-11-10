import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {

    private final List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        // Inicializando contas
        contas.add(new Conta("500-1", "Fulano", 1000.00));
        contas.add(new Conta("320-2", "Ciclano", 500.00));
    }

    public Conta getContaByCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public Transacao gerarTransacao(TransacaoRequestDTO requestDTO) {
        Conta origem = getContaByCodigo(requestDTO.origem());
        Conta destino = getContaByCodigo(requestDTO.destino());

        if (origem.getSaldo() < requestDTO.valor()) {
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem");
        }

        origem.setSaldo(origem.getSaldo() - requestDTO.valor());
        destino.setSaldo(destino.getSaldo() + requestDTO.valor());

        return new Transacao(origem, destino, requestDTO.valor());
    }
}

