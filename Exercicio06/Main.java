import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();

        // Loop para realizar a compra de ingressos
        while (true) {
            // Perguntar filme
            System.out.println("Que filme você deseja assistir?");
            String nomeFilme = scanner.nextLine();

            Filme filme = cinema.buscarFilme(nomeFilme);
            if (filme == null) {
                System.out.println("Filme não encontrado!");
                continue;
            }

            // Perguntar assento
            System.out.println("Qual assento você deseja?");
            String assento = scanner.nextLine();

            // Perguntar cliente
            System.out.println("Qual o seu nome?");
            String nomeCliente = scanner.nextLine();
            System.out.println("Qual a sua idade?");
            int idadeCliente = scanner.nextInt();
            scanner.nextLine();  // Consome a linha em branco restante

            Cliente cliente = new Cliente(nomeCliente, idadeCliente);

            // Tentar vender o ingresso
            try {
                cinema.venderIngresso(cliente, filme, assento);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Perguntar se deseja continuar
            System.out.println("Deseja comprar outro ingresso? (sim/nao)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("nao")) {
                break;
            }
        }

        scanner.close();
    }
}
