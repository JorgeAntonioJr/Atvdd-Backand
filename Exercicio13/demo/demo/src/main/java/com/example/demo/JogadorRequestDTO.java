import javax.validation.constraints.NotEmpty;

public class JogadorRequestDTO {

    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Apelido não pode ser vazio")
    private String apelido;

    // Getters e Setters

    public JogadorRequestDTO(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
    }

    public JogadorRequestDTO() {
    }
}
