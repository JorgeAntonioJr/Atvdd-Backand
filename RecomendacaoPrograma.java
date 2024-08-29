import java.util.Scanner;

public class RecomendacaoPrograma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pergunta 1: Ambientação
        System.out.println("Pergunta 1: Que ambientação você prefere?");
        System.out.println("1. Sci-fi");
        System.out.println("2. Medieval");
        int ambientacao = obterResposta(scanner);

        // Pergunta 2: Gênero
        System.out.println("\nPergunta 2: Que gênero você prefere?");
        System.out.println("1. Comédia");
        System.out.println("2. Drama");
        int genero = obterResposta(scanner);

        // Exibir recomendação
        String recomendacao = recomendarFilme(ambientacao, genero);
        System.out.println("\nRecomendação: " + recomendacao);

        scanner.close();
    }

    private static int obterResposta(Scanner scanner) {
        int resposta;
        try {
            resposta = scanner.nextInt();
            if (resposta != 1 && resposta != 2) {
                System.out.println("Número inválido. Encerrando o programa.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Encerrando o programa.");
            System.exit(0);
            return -1; // Para evitar erro de compilação, mas o código não alcançará esta linha
        }
        return resposta;
    }

    private static String recomendarFilme(int ambientacao, int genero) {
        if (ambientacao == 1) { // Sci-fi
            if (genero == 1) { // Comédia
                return "Homens de Preto";
            } else if (genero == 2) { // Drama
                return "Arrival";
            }
        } else if (ambientacao == 2) { // Medieval
            if (genero == 1) { // Comédia
                return "Shrek";
            } else if (genero == 2) { // Drama
                return "Gladiador";
            }
        }
        return "Desculpe, não temos uma recomendação para suas preferências.";
    }
}
