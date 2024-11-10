import java.util.ArrayList;

public class Cinema {
    private ArrayList<Filme> filmesDisponiveis;
    private ArrayList<Ingresso> ingressosVendidos;
    private ArrayList<String> assentosDisponiveis;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        ingressosVendidos = new ArrayList<>();
        assentosDisponiveis = new ArrayList<>();

        // Inicializando os assentos disponíveis
        for (char row = 'A'; row <= 'F'; row++) {
            for (int col = 1; col <= 5; col++) {
                assentosDisponiveis.add("" + row + col);  // Assentos A1, A2, ..., F5
            }
        }

        // Adicionando filmes
        filmesDisponiveis.add(new Filme("Homen Aranha", 20.00, 12));
        filmesDisponiveis.add(new Filme("Vingadores", 25.00, 10));
        filmesDisponiveis.add(new Filme("Batman", 18.00, 14));
        filmesDisponiveis.add(new Filme("Jurassic Park", 22.00, 10));
        filmesDisponiveis.add(new Filme("Frozen", 15.00, 0));
    }

    public Filme buscarFilme(String nome) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public boolean verificarIdade(Cliente cliente, Filme filme) {
        return cliente.getIdade() >= filme.getIdadeMinima();
    }

    public boolean verificarAssentoDisponivel(String assento) {
        return assentosDisponiveis.contains(assento);
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        if (!verificarAssentoDisponivel(assento)) {
            throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
        }

        if (!verificarIdade(cliente, filme)) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        // Remover assento da lista de disponíveis
        assentosDisponiveis.remove(assento);

        // Criar e adicionar ingresso
        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);

        System.out.println("Ingresso vendido com sucesso! " + filme.getNome() + " - " + assento + " - " + cliente.getNome());
    }
}
