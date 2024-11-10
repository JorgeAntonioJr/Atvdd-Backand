import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Criando inimigos
        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Orc", 100, 10));
        inimigos.add(new Personagem("Goblin", 50, 5));
        inimigos.add(new Personagem("Lobo", 75, 15));
        inimigos.add(new Personagem("Cavaleiro", 200, 20));
        inimigos.add(new Personagem("Dragão", 500, 50));

        // Criando o personagem jogador
        Personagem jogador = new Personagem("Steve", 100, 20);

        // Loop de combate
        while (jogador.estaVivo() && inimigos.stream().anyMatch(Personagem::estaVivo)) {
            // O jogador ataca um inimigo aleatório que ainda esteja vivo
            List<Personagem> inimigosVivos = inimigos.stream().filter(Personagem::estaVivo).toList();
            Personagem alvo = inimigosVivos.get(random.nextInt(inimigosVivos.size()));
            jogador.atacar(alvo);

            // Inimigos atacam de volta
            for (Personagem inimigo : inimigos) {
                if (inimigo.estaVivo()) {
                    inimigo.atacar(jogador);
                    if (!jogador.estaVivo()) {
                        break; // Se o jogador for derrotado, interrompe o loop
                    }
                }
            }
        }

        // Resultado final
        System.out.println("\nResultado Final:");
        if (jogador.estaVivo()) {
            System.out.println("Steve venceu todos os inimigos!");
        } else {
            System.out.println("Steve foi derrotado!");
        }

        // Exibindo o status final dos personagens
        System.out.println("\nStatus Final dos Personagens:");
        System.out.println("Steve - Vida: " + jogador.getVida());
        for (Personagem inimigo : inimigos) {
            System.out.println(inimigo);
        }
    }
}
