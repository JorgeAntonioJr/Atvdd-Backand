public class Personagem {
    private String nome;
    private int vida;
    private int ataque;

    // Construtor
    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    // Método para receber dano
    public void receberDano(int dano) {
        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nome + " foi derrotado!");
        }
    }

    // Método para atacar outro personagem
    public void atacar(Personagem alvo) {
        if (alvo.estaVivo()) {
            System.out.println(nome + " ataca " + alvo.getNome() + " causando " + ataque + " de dano!");
            alvo.receberDano(ataque);
        } else {
            System.out.println("O ataque de " + nome + " falhou! " + alvo.getNome() + " já está derrotado.");
        }
    }

    // Verifica se o personagem está vivo
    public boolean estaVivo() {
        return vida > 0;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    // Método para imprimir o status do personagem
    @Override
    public String toString() {
        return nome + " - Vida: " + vida + ", Ataque: " + ataque;
    }
}
