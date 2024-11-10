import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    private final List<JogadorResponseDTO> jogadores = new ArrayList<>();

    // Método para criar jogador
    public JogadorResponseDTO criarJogador(JogadorRequestDTO jogadorRequestDTO) {
        Random rand = new Random();
        int habilidade = rand.nextInt(101); // habilidade aleatória de 0 a 100

        JogadorResponseDTO jogadorResponseDTO = new JogadorResponseDTO(
                jogadorRequestDTO.nome(),
                jogadorRequestDTO.apelido(),
                habilidade,
                "Jogador criado com sucesso!"
        );

        jogadores.add(jogadorResponseDTO);
        return jogadorResponseDTO;
    }

    // Método para listar todos os jogadores
    public List<JogadorResponseDTO> listarJogadores() {
        return jogadores;
    }
}
