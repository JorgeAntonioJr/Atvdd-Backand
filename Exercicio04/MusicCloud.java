import java.util.ArrayList;
import java.util.List;

public class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        this.musicasDisponiveis = new ArrayList<>();
        carregarMusicas();
    }

    private void carregarMusicas() {
        musicasDisponiveis.add(new Musica("Hino do Real Paulista", "Real Paulista"));
        musicasDisponiveis.add(new Musica("Macarena", "Los del Rio"));
        musicasDisponiveis.add(new Musica("Evidências", "Chitãozinho & Xororó"));
        musicasDisponiveis.add(new Musica("Bohemian Rhapsody", "Queen"));
        musicasDisponiveis.add(new Musica("Billie Jean", "Michael Jackson"));
    }

    public Musica pesquisarMusica(String titulo) {
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }
}
