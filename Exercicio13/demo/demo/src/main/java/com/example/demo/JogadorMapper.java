import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {

    public JogadorResponseDTO toJogadorResponseDTO(Jogador jogador) {
        return new JogadorResponseDTO(jogador.getNome(), jogador.getApelido(), jogador.getHabilidade());
    }

    public Jogador toJogador(JogadorRequestDTO requestDTO) {
        return new Jogador(requestDTO.getNome(), requestDTO.getApelido(), (int) (Math.random() * 100)); // Habilidade aleatória
    }
}
