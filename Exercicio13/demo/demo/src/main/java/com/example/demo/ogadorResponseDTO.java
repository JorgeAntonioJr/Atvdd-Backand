public class JogadorResponseDTO {

    private String nome;
    private String apelido;
    private Integer habilidade;

    // Getters e Setters

    public JogadorResponseDTO(String nome, String apelido, Integer habilidade) {
        this.nome = nome;
        this.apelido = apelido;
        this.habilidade = habilidade;
    }

    public JogadorResponseDTO() {
    }
}
