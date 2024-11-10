import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Endpoint POST para criar um jogador
    @PostMapping
    public JogadorResponseDTO criarJogador(@RequestBody JogadorRequestDTO jogadorRequestDTO) {
        return jogadorService.criarJogador(jogadorRequestDTO);
    }

    // Endpoint GET para listar todos os jogadores
    @GetMapping
    public List<JogadorResponseDTO> listarJogadores() {
        return jogadorService.listarJogadores();
    }
}
