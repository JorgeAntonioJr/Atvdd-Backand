import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();

        System.out.print("Digite o nome da nova playlist: ");
        String nomePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        boolean continuar = true;

        while (continuar) {
            System.out.print("\nDigite o nome da música que deseja adicionar: ");
            String nomeMusica = scanner.nextLine();

            Musica musicaEncontrada = musicCloud.pesquisarMusica(nomeMusica);
            if (musicaEncontrada != null) {
                playlist.adicionarMusica(musicaEncontrada);
            } else {
                System.out.println("A música " + nomeMusica + " não foi encontrada no sistema.");
            }

            System.out.print("Deseja adicionar outra música? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        // Exibir a playlist final
        playlist.exibirPlaylist();
        scanner.close();
    }
}
