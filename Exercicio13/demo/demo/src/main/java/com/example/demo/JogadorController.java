import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorResponseDTO criarJogador(@RequestBody @Valid JogadorRequestDTO requestDTO) {
        return jogadorService.criarJogador(requestDTO);
    }

    @GetMapping
    public List<JogadorResponseDTO> listarJogadores() {
        return jogadorService.listarJogadores();
    }
}
