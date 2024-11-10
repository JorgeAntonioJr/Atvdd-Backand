import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String apelido;
    private Integer habilidade;

    // Getters e Setters

    public Jogador(String nome, String apelido, Integer habilidade) {
        this.nome = nome;
        this.apelido = apelido;
        this.habilidade = habilidade;
    }

    public Jogador() {
    }
}
