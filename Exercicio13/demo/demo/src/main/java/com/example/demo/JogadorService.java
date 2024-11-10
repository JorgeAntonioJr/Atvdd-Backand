import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final JogadorMapper jogadorMapper;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository, JogadorMapper jogadorMapper) {
        this.jogadorRepository = jogadorRepository;
        this.jogadorMapper = jogadorMapper;
    }

    public JogadorResponseDTO criarJogador(JogadorRequestDTO requestDTO) {
        Jogador jogador = jogadorMapper.toJogador(requestDTO);
        Jogador savedJogador = jogadorRepository.save(jogador);
        return jogadorMapper.toJogadorResponseDTO(savedJogador);
    }

    public List<JogadorResponseDTO> listarJogadores() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        return jogadores.stream()
                .map(jogadorMapper::toJogadorResponseDTO)
                .toList();
    }
}
